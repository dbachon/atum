package tk.tarajki.atum.book;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.tarajki.atum.author.Author;
import tk.tarajki.atum.author.AuthorRepository;
import tk.tarajki.atum.publisher.PublisherRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public List<BookDto> findBooks(BookFilter bookFilter) {
        if (bookFilter.getTitle() != null) {
            return bookRepository.findBooksByTitleLike("%" + bookFilter.getTitle() + "%").stream().map(BookDto::new).collect(Collectors.toList());
        }
        return bookRepository.findAllList().stream().map(BookDto::new).collect(Collectors.toList());
    }

    @Transactional
    public BookInfoDto add(BookAddRequest bookAddRequest){
        ArrayList<Author> authors = new ArrayList<>();
        authorRepository.findAllById(bookAddRequest.getAuthorsId()).iterator().forEachRemaining(authors::add);
        Book book = new Book(
                        bookAddRequest.getTitle(),
                        bookAddRequest.getGenre(),
                        authors,
                        publisherRepository.findByIdRequired(bookAddRequest.getPublisher())

                );
        bookRepository.save(book);
        return new  BookInfoDto(book);
    }

    @Transactional
    public void changeBookSettings(BookSettingsRequest bookSettingsRequest) {
        Book book = bookRepository.findBookById(bookSettingsRequest.getId());
        ArrayList<Author> authors = new ArrayList<>();
        authorRepository.findAllById(bookSettingsRequest.getAuthorsId()).iterator().forEachRemaining(authors::add);
        book.setTitle(bookSettingsRequest.getTitle());
        book.setAuthors(authors);
        book.setGenre(bookSettingsRequest.getGenre());
        book.setPublisher(publisherRepository.findByIdRequired(bookSettingsRequest.getPublisher()));
    }


}


