package tk.tarajki.atum.user;

import tk.tarajki.atum.auth.Role;
import tk.tarajki.atum.utils.enums.UserStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private UserStatus userStatus;

    public UserDto(String firstName, String lastName, String email, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }


    public UserDto(Long id, String firstName, String lastName, String email, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.userStatus = user.getUserStatus();
    }


    public UserDto() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}
