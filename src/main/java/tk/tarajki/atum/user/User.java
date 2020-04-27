package tk.tarajki.atum.user;

import tk.tarajki.atum.auth.Role;
import tk.tarajki.atum.borrowing.Borrowing;
import tk.tarajki.atum.utils.BaseEntity;
import tk.tarajki.atum.utils.enums.UserStatus;

import javax.persistence.*;
import java.util.List;

@Entity
public class User extends BaseEntity<Long> {
    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus = UserStatus.ACTIVE;
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Borrowing> borrowings;

    public User() {
    }

    public User(String firstName, String lastName, String email, Role role, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public User(String firstName, String lastName, String email, Role role, UserStatus userStatus, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.userStatus = userStatus;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }
}
