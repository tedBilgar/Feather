package mainSystem.dao.userRepository;

import mainSystem.model.userInitModels.Users;

public interface UserRepository {
    Users getUserById(int i);
    void addUser(Users users);
}
