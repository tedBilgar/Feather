package mainSystem.dao.taskListRepo;

import mainSystem.model.taskUnitModels.TaskList;

import java.util.List;

public interface TaskListRepository {
    TaskList getTaskListById(int id);
    List<TaskList> getAllTaskListByTableID(int tableID);
    TaskList addTaskList(TaskList taskList);
    void setTaskList(TaskList taskList);
    void deleteTaskList(int taskListID);
}
