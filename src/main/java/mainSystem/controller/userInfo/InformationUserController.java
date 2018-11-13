package mainSystem.controller.userInfo;

import mainSystem.model.taskUnitModels.Table;
import mainSystem.model.userInitModels.User;
import mainSystem.service.tableService.TableService;
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
    private UserService userService;
    @Autowired
    private TableService tableService;

    @RequestMapping(value = {"/info"},method = RequestMethod.GET)
    public ModelAndView createMainPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUsername(auth.getName());
        modelAndView.addObject("user",user);
        modelAndView.addObject("table",new Table());
        modelAndView.addObject("userTables",userService.getUserById(user.getId()).getTables());
        modelAndView.setViewName("userInfo/userInfo");
        return modelAndView;
    }
}
