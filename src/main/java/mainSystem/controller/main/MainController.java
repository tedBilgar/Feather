package mainSystem.controller.main;

import mainSystem.dao.TaskUnitRepos.groupRepository.GroupRepository;
import mainSystem.service.taskUnitService.tableService.TableService;
import mainSystem.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
