package tk.tarajki.atum.book;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tk.tarajki.atum.auth.UserPrincipal;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {


    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public List<BookDto> findBooks(@AuthenticationPrincipal UserPrincipal userPrincipal, @ModelAttribute BookFilter bookFilter){

            System.out.println(userPrincipal.getAuthorities());
        return bookService.findBooks(bookFilter);

    }

    @PostMapping
    public BookInfoDto add(@RequestBody BookAddRequest bookAddRequest) {
        return bookService.add(bookAddRequest);
    }


}
