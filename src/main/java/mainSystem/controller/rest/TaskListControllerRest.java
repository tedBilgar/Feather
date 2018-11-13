package mainSystem.controller.rest;

import mainSystem.model.taskUnitModels.TaskList;
import mainSystem.service.tableService.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rest/tasklist")
public class TaskListControllerRest {
    @Autowired
    private TableService tableService;

    @RequestMapping(value = "/{idTable}",method = RequestMethod.POST)
    public String addTaskList(@PathVariable("idTable")int idTable, @ModelAttribute TaskList taskList){
        tableService.addTaskList(idTable,taskList);
        return "redirect:/table/" + String.valueOf(idTable);
    }
}
