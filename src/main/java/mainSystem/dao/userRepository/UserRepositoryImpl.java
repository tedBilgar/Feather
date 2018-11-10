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
        User user =  (User) getCurrentSessionFactory().createQuery("from User u where u.id =: id ").setParameter("id",id).getSingleResult();
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
        getCurrentSessionFactory().delete(userId);
    }

    private Session getCurrentSessionFactory(){
        return sessionFactory.getCurrentSession();
    }

}
