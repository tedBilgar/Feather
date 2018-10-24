package mainSystem.service.userService;

import mainSystem.dao.userRepository.UserRepository;
import mainSystem.model.userInitModels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User getUserById(int i) {
        return userRepository.getUserById(i);
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

}
