package mainSystem.service.taskListService;

import mainSystem.dao.taskListRepo.TaskListRepository;
import mainSystem.model.taskUnitModels.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService{
    @Autowired
    private TaskListRepository taskListRepository;

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
}
