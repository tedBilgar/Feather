package mainSystem.controller.model_view.userInfo;

import mainSystem.model.taskUnitModels.TaskList;
import mainSystem.service.taskUnitService.tableService.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/table")
public class TableInfo {
    @Autowired
    private TableService tableService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView getTableMainPage(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("table",tableService.getTableById(id));
        modelAndView.addObject("newTask",new TaskList());
        modelAndView.addObject("taskLists",tableService.getAllTaskListOfTable(id));
        modelAndView.setViewName("userInfo/table");
        return modelAndView;
    }
}
