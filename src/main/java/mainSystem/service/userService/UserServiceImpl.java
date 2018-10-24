package mainSystem.service.userService;

import mainSystem.dao.userRepository.UserRepository;
import mainSystem.model.userInitModels.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User getUserById(int i) {
        return userRepository.getUserById(i);
    }

}
