package mainSystem.controller.rest;

import mainSystem.model.taskUnitModels.Table;
import mainSystem.model.taskUnitModels.Task;
import mainSystem.model.taskUnitModels.TaskList;
import mainSystem.service.taskUnitService.taskListService.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/rest/tasklist")
@RestController
public class TaskListControllerRest {
    @Autowired
    private TaskListService taskListService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public TaskList getTaskList(@PathVariable("id")int id){
        return taskListService.getTaskListById(id);
    }

    @RequestMapping(value = "/{id}/tasks/all",method = RequestMethod.GET)
    public Set<Task> getTasks(@PathVariable("id")int id){
        return taskListService.getTaskListById(id).getTasks();
    }

    @RequestMapping(value = "/{id}/tasks/add",method = RequestMethod.POST)
    public void addTask(@PathVariable("id")int id,@ModelAttribute Task task){
        taskListService.addTask(task, id);
    }

}
