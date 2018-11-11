package mainSystem.controller;

import mainSystem.model.userInitModels.User;
import mainSystem.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    //LOGIN
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "auth/login";
    }

    //REGISTRATION
    @GetMapping("/registration")
    public String userReg(Model model){
        model.addAttribute("user",new User());
        return "auth/registration";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "registration";
        }
        userService.addUser(user);
        return "redirect:/home";
    }
}
