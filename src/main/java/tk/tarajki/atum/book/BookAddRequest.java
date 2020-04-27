package tk.tarajki.atum.book;

import tk.tarajki.atum.utils.enums.Genre;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

public class BookAddRequest {
    private String title;
    private Genre genre;
    private List<Long> authorsId;
    private Long publisher;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Long> getAuthorsId() {
        return authorsId;
    }

    public void setAuthorsId(List<Long> authorsId) {
        this.authorsId = authorsId;
    }

    public Long getPublisher() {
        return publisher;
    }

    public void setPublisher(Long publisher) {
        this.publisher = publisher;
    }
}
