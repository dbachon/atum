package tk.tarajki.atum.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.tarajki.atum.utils.enums.UserStatus;

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
        System.out.println(userFilter.getFirstName());
        if (userFilter.getFirstName() != null || userFilter.getLastName() != null) {
            return userRepository.findUserByNames("%" + userFilter.getFirstName() + "%" +
                    "%" + userFilter.getLastName() + "%").stream().map(UserDto::new).collect(Collectors.toList());
        }
        return userRepository.findAllList().stream().map(UserDto::new).collect(Collectors.toList());
    }




    @Transactional
    public void banUser(UserBanRequest userBanRequest){
        User user = userRepository.findByIdRequired(userBanRequest.getId());
        user.setUserStatus(UserStatus.BANNED);
    }

    @Transactional
    public void unBanUser(UserBanRequest userBanRequest){
        User user = userRepository.findByIdRequired(userBanRequest.getId());
        user.setUserStatus(UserStatus.ACTIVE);
    }


    @Transactional
    public void changeRoleUser(UserChangeRoleRequest userChangeRoleRequest){
        User user = userRepository.findByIdRequired(userChangeRoleRequest.getId());
        user.setRole(userChangeRoleRequest.getRole());
    }

}
