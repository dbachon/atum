package tk.tarajki.atum.utils;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends CrudRepository<T, ID> {
    default T findByIdRequired(ID id) {
        Optional<T> entity = this.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RuntimeException("Not found");
        }
    }


    default List<T> findAllList() {
        List<T> list = new ArrayList<>();
        this.findAll().forEach(list::add);
        return list;
    }
}
