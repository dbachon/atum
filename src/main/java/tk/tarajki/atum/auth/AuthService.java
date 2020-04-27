package tk.tarajki.atum.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.tarajki.atum.user.User;
import tk.tarajki.atum.user.UserRepository;

@Service
public class AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private TokenProvider tokenProvider;

    public AuthService(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    public UserInfoDto login(LoginRequest loginRequest) {
        UserPrincipal p = (UserPrincipal) authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()))
                .getPrincipal();
        return createAuthResponse(p.getUser());
    }


    private UserInfoDto createAuthResponse(User user) {
        return new UserInfoDto(user.getEmail(), tokenProvider.createToken(user.getEmail()));
    }

    @Transactional
    public UserInfoDto register(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("User already exists");
    }
        User user = new User(
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getEmail(),
                Role.ADMIN,
                passwordEncoder.encode(registerRequest.getPassword())
        );
        return createAuthResponse(userRepository.save(user));

    }
}
