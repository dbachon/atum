package tk.tarajki.atum.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegisterRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Email
    private String email;
    @NotBlank
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
