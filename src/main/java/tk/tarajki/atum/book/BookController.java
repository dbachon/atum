package tk.tarajki.atum.book;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {


    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public List<BookDto> findBooks(@ModelAttribute BookFilter bookFilter) {
        return bookService.findBooks(bookFilter);

    }

    @PostMapping
    public BookInfoDto add(@RequestBody BookAddRequest bookAddRequest) {
        return bookService.add(bookAddRequest);
    }

    @PatchMapping
    public void changeBookSettings(@RequestBody BookSettingsRequest bookSettingsRequest) {
        bookService.changeBookSettings(bookSettingsRequest);
    }


}
