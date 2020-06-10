package tk.tarajki.atum.user;

import tk.tarajki.atum.auth.Role;
import tk.tarajki.atum.utils.enums.UserStatus;

public class UserChangeSettingsRequest {
    private Long id;
    private Role role;
    private UserStatus userStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}

