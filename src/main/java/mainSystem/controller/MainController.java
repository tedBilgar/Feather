package mainSystem.controller;

import mainSystem.dao.groupRepository.GroupRepository;
import mainSystem.model.userInitModels.Group;
import mainSystem.model.userInitModels.User;
import mainSystem.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/home")
    public String home(){
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
    public List<Group> getGroups(@RequestParam("id") int id){
        List<Group> groups = userService.getGroupsOfUser(id);
        System.out.println("GETTING");
        System.out.println(groups);
        return groups;
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

    //LOGIN
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "login";
    }

    //REG
    @GetMapping("/reg")
    public String userReg(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")User user, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            return "registration";
        }
        System.out.println("I~M HERE");
        userService.addUser(user);
        return "redirect:/home";
    }
}
