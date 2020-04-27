package tk.tarajki.atum.author;

public class AuthorInfoDto {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AuthorInfoDto(AuthorAddRequest authorAddRequest) {
        this.firstName = authorAddRequest.getFirstName();
        this.lastName = authorAddRequest.getLastName();
    }
}
