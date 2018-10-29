package mainSystem.dao.groupRepository;


import mainSystem.model.userInitModels.Group;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GroupRepositoryImpl implements GroupRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Group getGroupById(int groupId) {
        return (Group) sessionFactory.getCurrentSession().createQuery("from Group gr where gr.id =: id ").setParameter("id",groupId).getSingleResult();
    }
}
