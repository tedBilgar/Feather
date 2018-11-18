package mainSystem.dao.TaskUnitRepos.taskRepo;

import mainSystem.model.taskUnitModels.Task;


public interface TaskRepository {
    Task getTaskById(int id);
    Task addTaskList(Task task);
    void setTask(Task task);
    void deleteTask(int taskID);
}
