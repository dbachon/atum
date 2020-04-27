package tk.tarajki.atum.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class TokenBasedAuthentication extends AbstractAuthenticationToken {

    private UserDetails userDetails;
    private String token;

    public TokenBasedAuthentication(UserDetails userDetails, String token) {
        super(userDetails.getAuthorities());
        this.userDetails = userDetails;
        this.token = token;
    }

    @Override
    public String getCredentials() {
        return token;
    }

    @Override
    public UserDetails getPrincipal() {
        return userDetails;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }
}
