package mainSystem.controller.rest;

import mainSystem.model.taskUnitModels.Table;
import mainSystem.model.taskUnitModels.Task;
import mainSystem.model.taskUnitModels.TaskList;
import mainSystem.service.taskUnitService.taskListService.TaskListService;
import mainSystem.service.taskUnitService.taskService.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/rest/tasklist")
@RestController
public class TaskListControllerRest {
    @Autowired
    private TaskListService taskListService;

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public TaskList getTaskList(@PathVariable("id")int id){
        return taskListService.getTaskListById(id);
    }

    @RequestMapping(value = "/{id}/tasks/all",method = RequestMethod.GET)
    public Set<Task> getTasks(@PathVariable("id")int id){
        return taskListService.getTaskListById(id).getTasks();
    }

    @RequestMapping(value = "/{id}/tasks/add",method = RequestMethod.POST)
    public void addTask(@PathVariable("id")int id,@ModelAttribute("newTask") Task task){
        for (int taskID:
             task.getDependencyID()) {
            task.getTaskRelation().add(taskService.getTaskById(taskID));
        }
        taskListService.addTask(task, id);
    }

    //TODO make more clearly
    @RequestMapping(value = "/{id}/tasks/setRelation",method = RequestMethod.GET)
    public void setRelation(@RequestParam("parentID")int parentID,@RequestParam("taskID")int taskID){
        taskListService.setRelationBetweenTasks(parentID,taskID);
    }

    @RequestMapping(value = "/{id}/tasks/deleteRelation",method = RequestMethod.GET)
    public String deleteRelation(@RequestParam("parentID")int parentID,@RequestParam("taskID")int taskID){
        if (!taskListService.deleteRelationBetweenTasks(parentID,taskID)) return "Error";
        return "Nice";
    }

    @RequestMapping(value = "/merge",method = RequestMethod.GET)
    public String mergeTasks(@RequestParam("from")int fromID,@RequestParam("to")int toID){
        taskListService.changeTaskList(fromID, toID);
        return "Nice";
    }
}
