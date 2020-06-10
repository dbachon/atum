package tk.tarajki.atum.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tk.tarajki.atum.auth.UserPrincipal;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> findUsers(@ModelAttribute UserFilter userFilter){
        return userService.findUsers(userFilter);
    }

    @GetMapping("/my")
    public UserDto findUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return userService.findUser(userPrincipal);
    }


    @PatchMapping
    public void changeUserSettings(@RequestBody UserChangeSettingsRequest userChangeSettingsRequest) {
        userService.changeUserSettings(userChangeSettingsRequest);
    }


}
