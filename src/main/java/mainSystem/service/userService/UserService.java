package mainSystem.service.userService;

import mainSystem.model.userInitModels.Users;

public interface UserService {
    Users getUserById(int i);
    void addUser(Users users);
}
