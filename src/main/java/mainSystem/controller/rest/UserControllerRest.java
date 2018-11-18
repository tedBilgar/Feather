package mainSystem.controller.rest;

import mainSystem.model.taskUnitModels.Table;
import mainSystem.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/rest/user")
@RestController
public class UserControllerRest {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}/getTables",method = RequestMethod.GET)
    public Set<Table> getTables(@PathVariable("id")int id){
        return userService.getUserById(id).getTables();
    }

    @RequestMapping(value = "/{userID}/add/table",method = RequestMethod.POST)
    public Table addTable(@ModelAttribute Table table,@PathVariable("userID")int userID){
        return userService.addTable(userID,table);
    }
}
