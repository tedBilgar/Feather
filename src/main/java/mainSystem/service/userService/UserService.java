package mainSystem.service.userService;

import mainSystem.model.userInitModels.Group;
import mainSystem.model.userInitModels.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User getUserById(int i);
    void addUser(User user);
    List<Group> getGroupsOfUser(int userId);
    void updateUser(User user);
}
