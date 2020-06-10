package tk.tarajki.atum.copy;
import org.springframework.stereotype.Repository;
import tk.tarajki.atum.utils.BaseRepository;
import tk.tarajki.atum.utils.enums.Availability;

import java.util.List;

@Repository
public interface CopyRepository extends BaseRepository<Copy, Long> {

    List<Copy> findCopiesByAvailabilityNotLike(Availability availability);

    List<Copy> findCopiesByCodeLikeAndAvailabilityNotLike(String code, Availability availability);

    List<Copy> findAllByIdInAndAvailabilityIsLike (List<Long> id, Availability availability);

    List<Copy> findCopyByBook_TitleLikeAndAvailabilityNotLike(String title, Availability availability);

    List<Copy> findCopyByBook_TitleLike(String title);

    List<Copy> findCopiesByCodeLike(String code);
}
