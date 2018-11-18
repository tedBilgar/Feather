package mainSystem.dao.TaskUnitRepos.taskRepo;

import mainSystem.dao.TaskUnitRepos.taskListRepo.TaskListRepository;
import mainSystem.model.taskUnitModels.Task;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TaskRepositoryImpl implements TaskRepository{
    private static final Logger logger = Logger.getLogger(TaskRepository.class);

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSessionFactory(){
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public Task getTaskById(int id) {
        return (Task) getCurrentSessionFactory().createQuery("from Task t where t.id =:  id").setParameter("id",id).uniqueResult();
    }

    @Transactional
    public Task addTaskList(Task task) {
        getCurrentSessionFactory().save(task);
        return task;
    }

    @Transactional
    public void setTask(Task task) {
        getCurrentSessionFactory().update(task);
    }

    @Transactional
    public void deleteTask(int taskID) {
        getCurrentSessionFactory().delete(getTaskById(taskID));
    }
}
