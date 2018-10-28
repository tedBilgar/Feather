package mainSystem.dao.userRepository;

import mainSystem.model.userInitModels.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    //private List<User> userList = Arrays.asList(new User(1,"Denis","123456","papa149@mail.ru"));
    private static final Logger logger = Logger.getLogger(UserRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addUser(User user){
        getCurrentSessionFactory().save(user);
    }

    @Transactional
    public User getUserById(int id) {
        logger.info("Getting User By ID");
        return (User) getCurrentSessionFactory().createQuery("from User u where u.id =: id ").setParameter("id",id).getSingleResult();
    }

    @Transactional
    public void setUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Transactional
    public void deleteUser(User user) {

    }

    private Session getCurrentSessionFactory(){
        return sessionFactory.getCurrentSession();
    }

}
