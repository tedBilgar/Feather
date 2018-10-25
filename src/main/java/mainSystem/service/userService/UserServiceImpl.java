package mainSystem.service.userService;

import mainSystem.dao.userRepository.UserRepository;
import mainSystem.model.userInitModels.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    public Users getUserById(int i) {
        return userRepository.getUserById(i);
    }

    public void addUser(Users users) {
        userRepository.addUser(users);
    }
}
