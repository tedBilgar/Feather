package mainSystem.controller;

import mainSystem.model.userInitModels.Users;
import mainSystem.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(){
        return "main";
    }

    @GetMapping("/user")
    @ResponseBody
    public Users user(){
        return userService.getUserById(1);
    }

    @GetMapping("/addUser")
    public String add(){
        Users users = new Users("Denisio","3ddas","asdx");
        userService.addUser(users);
        return "main";
    }
}
