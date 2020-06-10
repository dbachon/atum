package tk.tarajki.atum.book;

import tk.tarajki.atum.author.AuthorBookDto;
import tk.tarajki.atum.publisher.Publisher;
import tk.tarajki.atum.publisher.PublisherBookDto;
import tk.tarajki.atum.utils.enums.Genre;

import java.util.List;
import java.util.stream.Collectors;

public class BookDto {
    private Long id;
    private String title;
    private List<AuthorBookDto>  authors;
    private PublisherBookDto publisher;
    private Genre genre;


    public BookDto(String title, List<AuthorBookDto> authors, Publisher publisher) {
        this.title = title;
        this.authors = authors;
        this.publisher = new PublisherBookDto(publisher);
    }

    public BookDto(String title) {
        this.title = title;
    }


    public BookDto(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
        this.authors = book.getAuthors().stream().map(AuthorBookDto::new).collect(Collectors.toList());
        this.publisher = new PublisherBookDto(book.getPublisher());
        this.genre = book.getGenre();
    }

    public List<AuthorBookDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorBookDto> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PublisherBookDto getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherBookDto publisher) {
        this.publisher = publisher;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
