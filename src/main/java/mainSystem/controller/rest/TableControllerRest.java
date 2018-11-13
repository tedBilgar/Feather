package mainSystem.controller.rest;

import mainSystem.model.taskUnitModels.Table;
import mainSystem.service.tableService.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/rest/table")
public class TableControllerRest {
    @Autowired
    private TableService tableService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addTable(@ModelAttribute Table table){
        tableService.addTable(table);
        return "redirect:/info";
    }



    @RequestMapping(value = "/load/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Table getTableByID(@PathVariable("id")int id){
        return tableService.getTableById(id);
    }

    @RequestMapping(value = "/load/all",method = RequestMethod.GET)
    @ResponseBody
    public List<Table> getAllTables(){
        return tableService.getAllTables();
    }
}
