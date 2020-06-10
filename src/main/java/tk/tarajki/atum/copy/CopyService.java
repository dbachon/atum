package tk.tarajki.atum.copy;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.tarajki.atum.book.BookRepository;
import tk.tarajki.atum.utils.enums.Availability;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CopyService {

    private CopyRepository copyRepository;
    private BookRepository bookRepository;

    public CopyService(CopyRepository copyRepository, BookRepository bookRepository) {
        this.copyRepository = copyRepository;
        this.bookRepository = bookRepository;
    }

    public List<CopyDto> findCopies(CopyFilter copyFilter){
        if (copyFilter.getCode() != null) {
            return copyRepository.findCopiesByCodeLikeAndAvailabilityNotLike("%" + copyFilter.getCode() + "%", Availability.DELETED).stream().map(CopyDto::new).collect(Collectors.toList());
        }
        return copyRepository.findCopiesByAvailabilityNotLike(Availability.DELETED).stream().map(CopyDto::new).collect(Collectors.toList());
    }

    public List<CopyDto> findCopiesByTitle(CopyFilter copyFilter) {
        if (copyFilter.getTitle() != null) {
            return copyRepository.findCopyByBook_TitleLikeAndAvailabilityNotLike("%" + copyFilter.getTitle() + "%", Availability.DELETED).stream().map(CopyDto::new).collect(Collectors.toList());
        }
        return copyRepository.findCopiesByAvailabilityNotLike(Availability.DELETED).stream().map(CopyDto::new).collect(Collectors.toList());
    }

    public List<CopyDto> findAllCopies(CopyFilter copyFilter) {
        if (copyFilter.getCode() != null) {
            return copyRepository.findCopiesByCodeLike("%" + copyFilter.getCode() + "%").stream().map(CopyDto::new).collect(Collectors.toList());
        } else if (copyFilter.getTitle() != null) {
            return copyRepository.findCopyByBook_TitleLike("%" + copyFilter.getTitle() + "%").stream().map(CopyDto::new).collect(Collectors.toList());
        }
        return copyRepository.findAllList().stream().map(CopyDto::new).collect(Collectors.toList());
    }


    @Transactional
    public void addCopy(CopyAddRequest copyAddRequest){
        Copy copy = new Copy(
                copyAddRequest.getCode(),
                bookRepository.findByIdRequired(copyAddRequest.getBookId())
        );
        copyRepository.save(copy);
    }

    @Transactional
    public void changeCopySettings(CopySettingsRequest copySettingsRequest) {
        Copy copy = copyRepository.findByIdRequired(copySettingsRequest.getId());
        copy.setAvailability(copySettingsRequest.getAvailability());
        copy.setBook(bookRepository.findByIdRequired(copySettingsRequest.getBookId()));
        copyRepository.save(copy);
    }




}
