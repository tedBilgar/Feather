package mainSystem.service.taskUnitService.taskListService;

import mainSystem.dao.TaskUnitRepos.taskListRepo.TaskListRepository;
import mainSystem.model.taskUnitModels.Task;
import mainSystem.model.taskUnitModels.TaskList;
import mainSystem.service.taskUnitService.taskService.TaskService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class TaskListServiceImpl implements TaskListService{
    @Autowired
    private TaskListRepository taskListRepository;

    @Autowired
    private TaskService taskService;

    public TaskList getTaskListById(int id) {
        return taskListRepository.getTaskListById(id);
    }

    public List<TaskList> getAllTaskListByTableID(int tableID) {
        return taskListRepository.getAllTaskListByTableID(tableID);
    }

    public TaskList addTaskList(TaskList taskList) {
        return taskListRepository.addTaskList(taskList);
    }

    public void setTaskList(TaskList taskList) {
        taskListRepository.setTaskList(taskList);
    }

    public void deleteTaskList(int taskListID) {
        taskListRepository.deleteTaskList(taskListID);
    }

    public void addTask(Task task,int task_listID){
        task.setTaskList(taskListRepository.getTaskListById(task_listID));
        taskService.addTaskList(task);
    }

    @Transactional
    public Set<Task> getTasksByTaskListID(int task_listID){
        Set<Task> tasks = taskListRepository.getTaskListById(task_listID).getTasks();
        Hibernate.initialize(tasks);
        return tasks;
    }
}
