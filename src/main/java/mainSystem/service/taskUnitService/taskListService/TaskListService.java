package mainSystem.service.taskUnitService.taskListService;

import mainSystem.model.taskUnitModels.Task;
import mainSystem.model.taskUnitModels.TaskList;

import java.util.List;
import java.util.Set;

public interface TaskListService {
    TaskList getTaskListById(int id);
    List<TaskList> getAllTaskListByTableID(int tableID);
    TaskList addTaskList(TaskList taskList);
    void setTaskList(TaskList taskList);
    void deleteTaskList(int taskListID);

    void addTask(Task task, int task_listID);
    Set<Task> getTasksByTaskListID(int task_listID);
}
