package mainSystem.service.taskUnitService.taskService;

import mainSystem.dao.TaskUnitRepos.taskRepo.TaskRepository;
import mainSystem.model.taskUnitModels.Task;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;


    public Task getTaskById(int id) {
        return taskRepository.getTaskById(id);
    }

    public Task addTaskList(Task task) {
        return taskRepository.addTaskList(task);
    }

    public void setTask(Task task) {
        taskRepository.setTask(task);
    }

    public void deleteTask(int taskID) {
        taskRepository.deleteTask(taskID);
    }

    @Transactional
    public List getRelationOfTask(int taskID){
        Task task = taskRepository.getTaskById(taskID);
        List taskRelation = task.getTaskRelation();
        Hibernate.initialize(taskRelation);
        return taskRelation;
    }
}
