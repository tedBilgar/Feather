package mainSystem.controller;

import mainSystem.model.userInitModels.User;
import mainSystem.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InformationUserController {
    @Autowired
    UserService userService;

   /* @GetMapping("/info")
    public String getAllUserInfo(){
        return "userInfo/userInfo";
    }*/

    @RequestMapping(value = {"/info"},method = RequestMethod.GET)
    public ModelAndView createMainPage(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUsername(auth.getName());
        System.out.println(user);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("userInfo/userInfo");
        return modelAndView;
    }
}
