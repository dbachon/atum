package tk.tarajki.atum.borrowing;

import org.springframework.stereotype.Service;
import tk.tarajki.atum.copy.Copy;
import tk.tarajki.atum.copy.CopyRepository;
import tk.tarajki.atum.user.User;
import tk.tarajki.atum.user.UserRepository;
import tk.tarajki.atum.utils.enums.Availability;
import tk.tarajki.atum.utils.enums.Status;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingService {

    private BorrowingRepository borrowingRepository;
    private CopyRepository copyRepository;
    private UserRepository userRepository;

    public BorrowingService(BorrowingRepository borrowingRepository, CopyRepository copyRepository, UserRepository userRepository) {
        this.borrowingRepository = borrowingRepository;
        this.copyRepository = copyRepository;
        this.userRepository = userRepository;
    }

    List<BorrowingDto> getBorrowingsByUser(User user, BorrowingFilter borrowingFilter) {
        if (borrowingFilter.getStatus() == Status.ALL) {
            return borrowingRepository.findBorrowingsByUser(user).stream().map(BorrowingDto::new).collect(Collectors.toList());
        }
        return borrowingRepository.findBorrowingsByUserAndStatus(user, borrowingFilter.getStatus()).stream().map(BorrowingDto::new).collect(Collectors.toList());
    }

    List<BorrowingDto> findBorrowings(BorrowingFilter borrowingFilter) {
        if (borrowingFilter.getEmail() == null) {
            borrowingFilter.setEmail("");
        }
        List<User> users = userRepository.findUsersByEmailLike("%" + borrowingFilter.getEmail() + "%");
        List<BorrowingDto> borrowingDtoList = new ArrayList<>();
        if (borrowingFilter.getStatus() == null || borrowingFilter.getStatus() == Status.ALL) {
            users.forEach(e -> borrowingDtoList.addAll(borrowingRepository.findBorrowingsByUser(e).stream().map(BorrowingDto::new).collect(Collectors.toList())));
        } else {
            users.forEach(e -> borrowingDtoList.addAll(borrowingRepository.findBorrowingsByUserAndStatus(e, borrowingFilter.getStatus()).stream().map(BorrowingDto::new).collect(Collectors.toList())));

        }
        return borrowingDtoList;

    }

    @Transactional
    public void  addBorrowing(User user, BorrowingAddRequest borrowingAddRequest){
        ArrayList<Copy> copies = new ArrayList<>();
        copyRepository.findAllByIdInAndAvailabilityIsLike(borrowingAddRequest.getCopiesId(), Availability.AVAILABLE).iterator().forEachRemaining(copies::add);
        copies.forEach(e -> e.setAvailability(Availability.UNAVAILABLE));

        Borrowing borrowing = new Borrowing(
                user,
                Status.ACTIVE,
                copies
        );
        borrowingRepository.save(borrowing);
    }

    @Transactional
    public void returnBorrowing(BorrowingReturnRequest borrowingReturnRequest){
        Borrowing borrowing = borrowingRepository.findByIdRequired(borrowingReturnRequest.getId());
        borrowing.setStatus(Status.WAITING);
        borrowing.setReturnedDate(new Date());

    }

    @Transactional
    public void acceptReturnBorrowing(BorrowingAcceptRequest borrowingAcceptRequest) {
        Borrowing borrowing = borrowingRepository.findByIdRequired(borrowingAcceptRequest.getId());
        borrowing.setStatus(borrowingAcceptRequest.getStatus());
        List<Copy> copies = borrowing.getCopies();
        if (borrowingAcceptRequest.getStatus() == Status.FINISHED) {
            copies.forEach(e -> e.setAvailability(Availability.AVAILABLE));
        }
    }

}
