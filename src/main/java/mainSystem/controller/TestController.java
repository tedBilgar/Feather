package mainSystem.controller;

import mainSystem.dao.tableRepo.TableRepository;
import mainSystem.dao.userRepository.UserRepository;
import mainSystem.model.taskUnitModels.Table;
import mainSystem.model.userInitModels.Group;
import mainSystem.model.userInitModels.User;
import mainSystem.service.tableService.TableService;
import mainSystem.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
public class TestController {
    @Autowired
    UserService userService;

    @Autowired
    TableRepository tableRepository;

    @Autowired
    TableService tableService;

    @GetMapping("/test")
    @ResponseBody
    public Set<User> getTest(){
        System.out.println(userService.getUserById(2).getTables());
        return tableService.getUserSetOfTable(1);
    }

    @GetMapping("/test2")
    @ResponseBody
    public List<Group> getTest2(){
        System.out.println(userService.getUserById(2).getTables());
        return userService.getUserById(2).getGroups();
    }
}
