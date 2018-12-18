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


    //--------------------Custom functions for using Tasks-----------------------------------------------------

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



    public void setTaskRelation(int taskID, List tasksDependencies){
        Task task = taskService.getTaskById(taskID);
        task.setTaskRelation(tasksDependencies);
        taskService.setTask(task);
    }

    //TODO Unique Value
    public void setRelationBetweenTasks(int taskParentID, int taskID) {
        Task parent = taskService.getTaskById(taskParentID);
        Task task = taskService.getTaskById(taskID);
        task.getTaskRelation().add(parent);
        taskService.setTask(task);
    }

    public boolean deleteRelationBetweenTasks(int taskParentID, int taskID) {
        Task task = taskService.getTaskById(taskID);
        List<Task> taskList = task.getTaskRelation();
        for (Task relativeTask:
             taskList) {
            if (relativeTask.getId() == taskParentID){
                task.getTaskRelation().remove(relativeTask);
                taskService.setTask(task);
                return true;
            }
        }
        Task task2 = taskService.getTaskById(taskParentID);
        List<Task> taskList2 = task2.getTaskRelation();
        for (Task relativeTask2:
             taskList2) {
            if(relativeTask2.getId() == taskID){
                task2.getTaskRelation().remove(relativeTask2);
                taskService.setTask(task2);
                return true;
            }
        }
        return false;
    }

    public void changeTaskList(int old_taskListID, int new_taskListID) {
        TaskList oldList = taskListRepository.getTaskListById(old_taskListID);
        TaskList newList = taskListRepository.getTaskListById(new_taskListID);

        for (Task task: oldList.getTasks()) {
            task.setTaskList(newList);
            taskService.setTask(task);
        }

    }


}
