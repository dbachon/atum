package tk.tarajki.atum.publisher;

import tk.tarajki.atum.book.Book;
import tk.tarajki.atum.utils.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Publisher extends BaseEntity<Long> {

    private String name;
    private String telephone;
    private String email;


    @JoinColumn(name = "publisher_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Book> books;

    public Publisher() {
    }

    public Publisher(String name, String telephone, String email) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
