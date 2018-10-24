package mainSystem.service.userService;

import mainSystem.model.userInitModels.User;

public interface UserService {
    User getUserById(int i);
    void addUser(User user);
}
