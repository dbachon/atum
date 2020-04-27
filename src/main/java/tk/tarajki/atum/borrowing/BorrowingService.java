package tk.tarajki.atum.borrowing;

import jdk.jshell.Snippet;
import org.springframework.stereotype.Service;

import tk.tarajki.atum.copy.Copy;
import tk.tarajki.atum.copy.CopyRepository;
import tk.tarajki.atum.user.User;
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


    public BorrowingService(BorrowingRepository borrowingRepository, CopyRepository copyRepository) {
        this.borrowingRepository = borrowingRepository;
        this.copyRepository = copyRepository;
    }

    List<BorrowingDto> getBorrowingsByUser(User user){
        return borrowingRepository.findBorrowingsByUser(user).stream().map(BorrowingDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void  addBorrowing(User user, BorrowingAddRequest borrowingAddRequest){
        ArrayList<Copy> copies = new ArrayList<>();
        copyRepository.findAllByIdInAndAvailabilityIsLike(borrowingAddRequest.getCopiesId(), Availability.AVAILABLE).iterator().forEachRemaining(copies::add);
        copies.stream().forEach(e -> e.setAvailability(Availability.UNAVAILABLE));

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
        borrowing.setStatus(Status.FINISHED);
        borrowing.setReturnedDate(new Date());
        List<Copy> copies =  borrowing.getCopies();
        copies.stream().forEach(e -> e.setAvailability(Availability.AVAILABLE));
    }

}
