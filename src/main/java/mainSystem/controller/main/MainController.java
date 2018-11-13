package mainSystem.controller.main;

import mainSystem.dao.groupRepository.GroupRepository;
import mainSystem.model.taskUnitModels.Table;
import mainSystem.model.userInitModels.Group;
import mainSystem.model.userInitModels.User;
import mainSystem.service.tableService.TableService;
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
@RequestMapping("/main")
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private TableService tableService;

    @Autowired
    private GroupRepository groupRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMainPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tables",tableService.getAllTables());
        modelAndView.setViewName("main");
        return modelAndView;
    }


}
