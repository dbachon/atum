package tk.tarajki.atum.copy;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.tarajki.atum.book.BookRepository;

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
            return copyRepository.findCopiesByCodeLike("%" + copyFilter.getCode() + "%").stream().map(CopyDto::new).collect(Collectors.toList());
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



}
