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

    @PostMapping
    public AuthorInfoDto add(@RequestBody AuthorAddRequest authorAddRequest) {
        return authorService.add(authorAddRequest);
    }

    @PatchMapping
    public void changeAuthorSettings(@RequestBody AuthorSettingRequest authorSettingRequest) {
        authorService.changeAuthorSettings(authorSettingRequest);
    }

}
