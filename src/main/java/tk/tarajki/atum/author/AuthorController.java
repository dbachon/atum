package tk.tarajki.atum.author;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDto> findAuthors(@ModelAttribute AuthorFilter authorFilter){
            return authorService.findAuthors(authorFilter);
    }
/*
    @GetMapping
    public List<BookDto> findBooksAuthors(@ModelAttribute AuthorFilter authorFilter){
        return authorService.findBooksAuthors(authorFilter);
    }
*/
    @PostMapping
    public AuthorInfoDto add(@RequestBody AuthorAddRequest authorAddRequest) {
        return authorService.add(authorAddRequest);
    }

}
