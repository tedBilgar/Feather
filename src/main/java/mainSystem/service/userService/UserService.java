package mainSystem.service.userService;

import mainSystem.model.taskUnitModels.Table;
import mainSystem.model.userInitModels.Group;
import mainSystem.model.userInitModels.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User getUserById(int id);
    User getUserByUsername(String username);
    void addUser(User user);
    List<Group> getGroupsOfUser(int userId);
    void updateUser(User user);

    //Custom api service
    Table addTable(int userID, Table table);
    Set<Table> getAllTables(int userID);
    Table getTableByID(int tableID);
}
