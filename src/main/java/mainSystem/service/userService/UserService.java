package mainSystem.service.userService;

import mainSystem.model.userInitModels.Group;
import mainSystem.model.userInitModels.User;

import java.util.Set;

public interface UserService {
    User getUserById(int i);
    void addUser(User user);
    Set<Group> getGroupsOfUser(int userId);
}
