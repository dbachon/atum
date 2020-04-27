package tk.tarajki.atum.copy;
import tk.tarajki.atum.book.Book;
import tk.tarajki.atum.utils.BaseEntity;
import tk.tarajki.atum.utils.enums.Availability;

import javax.persistence.*;


@Entity
public class Copy extends BaseEntity<Long> {
    private String code;

    @Enumerated(EnumType.STRING)
    private Availability availability = Availability.AVAILABLE;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    public Copy() {
    }

    public Copy(String code, Book book) {
        this.code = code;
        this.book = book;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}
