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

    @Transactional
    public Users getUserById(int id) {
        logger.info("Getting Users By ID");
    }

    @Transactional
    public Users getUserByEmail(String email) {
        String query = "FROM useres u select u where ";
        return null;
    }

    @Transactional
    public void setUser(Users user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Transactional
    public void deleteUser(Users users) {

    }


}
