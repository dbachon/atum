package tk.tarajki.atum.author;

public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;

    public AuthorDto(Author author) {
        this.id = author.getId();
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
