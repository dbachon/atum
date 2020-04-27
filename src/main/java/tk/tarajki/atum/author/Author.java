package tk.tarajki.atum.author;

import tk.tarajki.atum.book.Book;
import tk.tarajki.atum.utils.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Author extends BaseEntity<Long> {

    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authors")
    private List<Book> books;


    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
