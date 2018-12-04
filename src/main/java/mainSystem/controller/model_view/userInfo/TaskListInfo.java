package mainSystem.controller.model_view.userInfo;

import mainSystem.model.taskUnitModels.Task;
import mainSystem.model.taskUnitModels.TaskList;
import mainSystem.service.taskUnitService.taskListService.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/tasklist")
public class TaskListInfo {
    @Autowired
    private TaskListService taskListService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView getTaskListInfo(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tasklist",taskListService.getTaskListById(id));
        modelAndView.addObject("newTask",new Task());
        modelAndView.addObject("tasks",taskListService.getTasksByTaskListID(id));
        modelAndView.setViewName("userInfo/tasklist");
        return modelAndView;
    }
}
