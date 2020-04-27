package tk.tarajki.atum.auth;

import io.swagger.annotations.Api;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public UserInfoDto login(@RequestBody @Valid LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }


    @PostMapping("/register")
    public UserInfoDto register(@RequestBody @Valid RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

/* <REMEMBER>
    @GetMapping
    public String getEmail(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return userPrincipal.getUser().getEmail();
    }
*/
}
