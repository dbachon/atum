package tk.tarajki.atum.auth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import tk.tarajki.atum.utils.expeptions.AuthException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFilter extends OncePerRequestFilter {

    private TokenProvider tokenProvider;
    private UserDetailsServiceImpl userDetailsService;
    private static final String tokenPrefix = "Bearer ";

    public AuthFilter(TokenProvider tokenProvider, UserDetailsServiceImpl userDetailsService) {
        this.tokenProvider = tokenProvider;
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenFromRequest(request);

        if (token != null) {
            String email = tokenProvider.getSubject(token);
            try {
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                SecurityContextHolder.getContext().setAuthentication(new TokenBasedAuthentication(userDetails, token));
            } catch (UsernameNotFoundException e) {
                throw new AuthException(e.getMessage());
            }
        }
        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null) {
            return null;
        }
        if (!header.startsWith(tokenPrefix)) {
            return null;
        }
        return header.substring(tokenPrefix.length());

    }
}
