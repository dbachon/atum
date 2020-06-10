package tk.tarajki.atum.book;

import org.springframework.stereotype.Repository;
import tk.tarajki.atum.author.Author;
import tk.tarajki.atum.utils.BaseRepository;

import java.util.List;

@Repository
public interface BookRepository extends BaseRepository<Book, Long> {
    Book findBookByTitle(String title);

    Book findBookById(Long id);

    Book findBookByAuthors(Author author);


    List<Book> findBooksByTitleLike(String title);
}
