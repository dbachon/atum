package tk.tarajki.atum.author;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorDto> findAuthors(AuthorFilter authorFilter) {
        if (authorFilter.getFirstName() != null || authorFilter.getLastName() != null) {
            return authorRepository.findByNames("%" + authorFilter.getFirstName() + "%" +
                    "%" + authorFilter.getLastName() + "%").stream().map(AuthorDto::new).collect(Collectors.toList());
        }
        return authorRepository.findAllList().stream().map(AuthorDto::new).collect(Collectors.toList());
    }

    @Transactional
    public AuthorInfoDto add(AuthorAddRequest authorAddRequest) {
        Author author = new Author(
                authorAddRequest.getFirstName(),
                authorAddRequest.getLastName()
        );
        authorRepository.save(author);
        return new AuthorInfoDto(authorAddRequest);
    }

    @Transactional
    public void changeAuthorSettings(AuthorSettingRequest authorSettingRequest) {
        Author author = authorRepository.findByIdRequired(authorSettingRequest.getId());
        author.setFirstName(authorSettingRequest.getFirstName());
        author.setLastName(authorSettingRequest.getLastName());
    }
}

