package tk.tarajki.atum.book;

import tk.tarajki.atum.author.AuthorBookDto;

import java.util.List;
import java.util.stream.Collectors;

public class BookCopyDto {
    private Long id;
    private String title;
    private List<AuthorBookDto> authors;

    public BookCopyDto() {
    }

    public BookCopyDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.authors = book.getAuthors().stream().map(AuthorBookDto::new).collect(Collectors.toList());;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AuthorBookDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorBookDto> authors) {
        this.authors = authors;
    }
}
