package tk.tarajki.atum.author;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tk.tarajki.atum.utils.BaseRepository;

import java.util.List;


@Repository
public interface AuthorRepository extends BaseRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE LOWER(CONCAT(a.firstName , ' ', a.lastName)) LIKE :name")
    List<Author> findByNames(@Param("name") String name);

}
