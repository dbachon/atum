package tk.tarajki.atum.copy;
import org.springframework.stereotype.Repository;
import tk.tarajki.atum.utils.BaseRepository;
import tk.tarajki.atum.utils.enums.Availability;

import java.util.List;

@Repository
public interface CopyRepository extends BaseRepository<Copy, Long> {

    List<Copy> findCopiesByCodeLike(String code);

    List<Copy> findAllByIdInAndAvailabilityIsLike (List<Long> id, Availability availability);
}
