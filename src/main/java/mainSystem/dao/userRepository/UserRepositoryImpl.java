package mainSystem.dao.userRepository;

import mainSystem.model.userInitModels.Users;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    //private List<Users> userList = Arrays.asList(new Users(1,"Denis","123456","papa149@mail.ru"));
    private static final Logger logger = Logger.getLogger(UserRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addUser(Users users){
        sessionFactory.getCurrentSession().save(users);
    }

    public Users getUserById(int i) {
        logger.info("Getting Users By ID");
        /*for (Users user:
                userList) {
            if (user.getId() == i) return user;
        }*/
        return null;
    }
}
