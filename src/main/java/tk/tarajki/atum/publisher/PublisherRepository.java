package tk.tarajki.atum.publisher;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.tarajki.atum.utils.BaseRepository;

import java.util.List;

@Repository
public interface PublisherRepository extends BaseRepository<Publisher, Long> {
    List<Publisher> findPublishersByNameLike(String name);
}
