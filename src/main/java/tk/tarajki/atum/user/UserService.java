package tk.tarajki.atum.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.tarajki.atum.auth.UserPrincipal;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private  UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public List<UserDto> findUsers(UserFilter userFilter) {


        if (userFilter.getEmail() != null) {
            return userRepository.findUsersByEmailLike("%" + userFilter.getEmail() + "%").stream().map(UserDto::new).collect(Collectors.toList());
        }
        if (userFilter.getFirstName() != null || userFilter.getLastName() != null) {
            return userRepository.findUserByNames("%" + userFilter.getFirstName() + "%" +
                    "%" + userFilter.getLastName() + "%").stream().map(UserDto::new).collect(Collectors.toList());
        }
        return userRepository.findAllList().stream().map(UserDto::new).collect(Collectors.toList());
    }

    public UserDto findUser(UserPrincipal userPrincipal) {
        return new UserDto(userPrincipal.getUser());
    }



    @Transactional
    public void changeUserSettings(UserChangeSettingsRequest userChangeSettingsRequest) {
        User user = userRepository.findByIdRequired(userChangeSettingsRequest.getId());
        user.setUserStatus(userChangeSettingsRequest.getUserStatus());
        user.setRole(userChangeSettingsRequest.getRole());
    }


}
