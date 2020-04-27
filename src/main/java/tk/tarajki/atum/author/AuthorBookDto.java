package tk.tarajki.atum.author;

public class AuthorBookDto {
    private String firstName;
    private String lastName;

    public AuthorBookDto(Author author) {
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
}
