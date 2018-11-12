package mainSystem.dao.userRepository;

import mainSystem.model.userInitModels.User;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final Logger logger = Logger.getLogger(UserRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addUser(User user){
        logger.info("Adding user ID: " + user.getId());
        getCurrentSessionFactory().save(user);
    }

    @Transactional
    public User getUserById(int id) {
        logger.info("Getting User By ID");
        User user =  (User) getCurrentSessionFactory().createQuery("from User u where u.id =: id ").setParameter("id",id).uniqueResult();
        if (user == null) {
            logger.error("No Found User with ID: " + id);
            return null;
        }
        Hibernate.initialize(user.getGroups());
        Hibernate.initialize(user.getTables());
        return user;
    }

    @Transactional
    public User getUserByUsername(String username) {
        logger.info("Getting User By Username");
        User user = (User) getCurrentSessionFactory().createQuery("from User u where u.username =: username").setParameter("username",username).uniqueResult();
        if (user == null) {
            logger.error("No Found User with username: " + username);
            return null;
        }
        Hibernate.initialize(user.getGroups());
        return user;
    }

    @Transactional
    public void setUser(User user) {
        logger.info("Updating user ID " + user.getId());
        getCurrentSessionFactory().update(user);
    }

    @Transactional
    public void deleteUser(int userId) {
        logger.info("Deleting user ID: " + userId);
        User user =  (User) getCurrentSessionFactory().createQuery("from User u where u.id =: id ").setParameter("id",userId).uniqueResult();
        if (user == null) {
            logger.error("No Found User with ID: " + userId);
            return;
        }
        getCurrentSessionFactory().delete(userId);
    }

    private Session getCurrentSessionFactory(){
        return sessionFactory.getCurrentSession();
    }

}
