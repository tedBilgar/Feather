package mainSystem.dao.userRepository;

import mainSystem.model.userInitModels.User;
import mainSystem.service.userService.UserService;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private List<User> userList = Arrays.asList(new User(1,"Denis","123456","papa149@mail.ru"));
    private static final Logger logger = Logger.getLogger(UserRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addUser(User user){
        sessionFactory.getCurrentSession().save(user);
    }

    public User getUserById(int i) {
        logger.info("Getting User By ID");
        for (User user:
                userList) {
            if (user.getId() == i) return user;
        }
        return null;
    }
}
