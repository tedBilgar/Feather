package mainSystem.dao.taskListRepo;

import mainSystem.dao.tableRepo.TableRepository;
import mainSystem.model.taskUnitModels.TaskList;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TaskListRepositoryImpl implements TaskListRepository {
    private static final Logger logger = Logger.getLogger(TaskListRepository.class);

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSessionFactory(){
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public TaskList getTaskListById(int id) {
        return (TaskList) getCurrentSessionFactory().createQuery("from TaskList tl where tl.id =:  id").setParameter("id",id).uniqueResult();
    }

    @Transactional
    public List<TaskList> getAllTaskListByTableID(int tableID) {
        return getCurrentSessionFactory().createQuery("from TaskList tl where tl.taskTable =: tableID").setParameter("tableID",tableID).list();
    }

    @Transactional
    public TaskList addTaskList(TaskList taskList) {
        getCurrentSessionFactory().save(taskList);
        return taskList;
    }

    @Transactional
    public void setTaskList(TaskList taskList) {
        getCurrentSessionFactory().update(taskList);
    }

    @Transactional
    public void deleteTaskList(int taskListID) {
        TaskList taskList = getTaskListById(taskListID);
        getCurrentSessionFactory().delete(taskList);
    }
}
