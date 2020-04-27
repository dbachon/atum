package tk.tarajki.atum.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    @DeleteMapping
    public void banUser(@RequestBody UserBanRequest userBanRequest) {
       userService.banUser(userBanRequest);
    }

    @PutMapping
    public void unBanUser(@RequestBody UserBanRequest userBanRequest) {
        userService.unBanUser(userBanRequest);
    }

    @PatchMapping
    public void changeRoleUser(@RequestBody UserChangeRoleRequest userChangeRoleRequest) {
        userService.changeRoleUser(userChangeRoleRequest);
    }



}
