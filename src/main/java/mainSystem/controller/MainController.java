package mainSystem.controller;

import mainSystem.dao.groupRepository.GroupRepository;
import mainSystem.model.taskUnitModels.Table;
import mainSystem.model.userInitModels.Group;
import mainSystem.model.userInitModels.User;
import mainSystem.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private GroupRepository groupRepository;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String hello(Model model) {
        //model.addAttribute("message", "Spring MVC Thymeleaf Hello World Example!!");
        String hi = "DENIS";
        model.addAttribute("user23",hi);
        return "main";
    }

    @GetMapping("/user")
    @ResponseBody
    public User user(){
        return userService.getUserById(1);
    }

    @GetMapping("/addUser")
    public String add(){
        User user = new User("Denisio","3ddas","asdx");
        userService.addUser(user);
        return "main";
    }

    @GetMapping("/")
    @ResponseBody
    public Set<Table> getGroups(@RequestParam("id") int id){
        Set<Table> tables = userService.getUserById(id).getTables();
        System.out.println("GETTING");
        return tables;
    }

    @GetMapping("/get")
    @ResponseBody
    public User getUser(){
        return userService.getUserByUsername("Denis");
    }

    @GetMapping("/add")
    @ResponseBody
    public String gets(){
        userService.addUser(new User("news","pass","email123"));
        return "main";
    }


}
