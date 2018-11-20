package mainSystem.service.taskUnitService.taskService;

import mainSystem.model.taskUnitModels.Task;

import java.util.Set;

public interface TaskService {
    Task getTaskById(int id);
    Task addTaskList(Task task);
    void setTask(Task task);
    void deleteTask(int taskID);
    Set<Task> getRelationOfTask(int taskID);
}
