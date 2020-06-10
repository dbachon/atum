package tk.tarajki.atum.borrowing;

import org.springframework.stereotype.Repository;
import tk.tarajki.atum.user.User;
import tk.tarajki.atum.utils.BaseRepository;
import tk.tarajki.atum.utils.enums.Status;

import java.util.List;

@Repository
public interface BorrowingRepository extends BaseRepository<Borrowing, Long> {

 List<Borrowing> findBorrowingsByUser(User user);

    List<Borrowing> findBorrowingsByUserAndStatus(User user, Status status);


}
