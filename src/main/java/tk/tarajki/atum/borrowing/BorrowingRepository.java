package tk.tarajki.atum.borrowing;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.tarajki.atum.user.User;
import tk.tarajki.atum.utils.BaseRepository;

import java.util.List;

@Repository
public interface BorrowingRepository extends BaseRepository<Borrowing, Long> {

 List<Borrowing> findBorrowingsByUser(User user);


}
