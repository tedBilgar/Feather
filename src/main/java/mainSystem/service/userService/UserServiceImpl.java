package mainSystem.service.userService;

import mainSystem.dao.tableRepo.TableRepository;
import mainSystem.dao.userRepository.UserRepository;
import mainSystem.model.taskUnitModels.Table;
import mainSystem.model.userInitModels.Group;
import mainSystem.model.userInitModels.User;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final Logger logger = Logger.getLogger(UserService.class);


    public User getUserById(int id) {
        User user = userRepository.getUserById(id);
        if (user == null) {
            logger.error("No Found User with ID: " + id);
            return null;
        }
        return user;
    }

    public User getUserByUsername(String username) {
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            logger.error("No Found User with username: " + username);
            return null;
        }
        return user;
    }

    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.addUser(user);
    }

    public List<Group> getGroupsOfUser(int userId) {
        User user = userRepository.getUserById(userId);
        Hibernate.initialize(user.getGroups());
        return user.getGroups();
    }

    public void updateUser(User user){
        userRepository.setUser(user);
    }

    public void getTable(int userID,Table table) {
        User user = userRepository.getUserById(userID);
        user.getTables().add(table);
        userRepository.setUser(user);
    }
}
