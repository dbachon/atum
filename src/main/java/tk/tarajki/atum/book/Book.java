package tk.tarajki.atum.book;

import tk.tarajki.atum.author.Author;
import tk.tarajki.atum.publisher.Publisher;
import tk.tarajki.atum.copy.Copy;
import tk.tarajki.atum.utils.BaseEntity;
import tk.tarajki.atum.utils.enums.Genre;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book extends BaseEntity<Long> {
    private String title;


    @Enumerated(EnumType.STRING)
    private Genre genre;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id" )},
            inverseJoinColumns = {@JoinColumn(name = "author_id" )})
    private List<Author> authors;

    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisher;

    @JoinColumn(name = "book_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Copy> copies;

    public Book() {
    }

    public Book(String title,Genre genre, List<Author> authors, Publisher publisher) {
        this.title = title;
        this.genre = genre;
        this.authors = authors;
        this.publisher = publisher;
    }



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

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
