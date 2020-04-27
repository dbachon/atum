package tk.tarajki.atum.user;

import tk.tarajki.atum.auth.Role;

public class UserChangeRoleRequest {

        private Long id;
        private Role role;

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
}
