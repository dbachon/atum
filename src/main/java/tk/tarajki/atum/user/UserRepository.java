package tk.tarajki.atum.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tk.tarajki.atum.utils.BaseRepository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    User findUserByEmail(String email);
    Boolean existsByEmail(String email);

    List<User> findUsersByEmailLike(String email);

    @Query("SELECT u FROM User u WHERE LOWER(CONCAT(u.firstName , ' ', u.lastName)) LIKE :name")
    List<User> findUserByNames(@Param("name") String name);


}
