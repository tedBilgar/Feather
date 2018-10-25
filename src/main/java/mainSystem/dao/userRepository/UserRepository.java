package mainSystem.dao.userRepository;

import mainSystem.model.userInitModels.Users;

public interface UserRepository {
    Users getUserById(int id);
    void addUser(Users users);
    Users getUserByEmail(String email);
    void setUser(Users user);
    void deleteUser(Users users);
}
