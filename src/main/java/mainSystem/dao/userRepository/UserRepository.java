package mainSystem.dao.userRepository;

import mainSystem.model.userInitModels.User;

public interface UserRepository {
    User getUserById(int id);
    User getUserByUsername(String username);
    void addUser(User user);
    void setUser(User user);
    void deleteUser(int userId);
}
