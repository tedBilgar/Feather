package mainSystem.controller;

import mainSystem.dao.TaskUnitRepos.tableRepo.TableRepository;
import mainSystem.dao.TaskUnitRepos.taskListRepo.TaskListRepository;
import mainSystem.model.taskUnitModels.Task;
import mainSystem.model.userInitModels.Group;
import mainSystem.service.taskUnitService.tableService.TableService;
import mainSystem.service.taskUnitService.taskListService.TaskListService;
import mainSystem.service.taskUnitService.taskService.TaskService;
import mainSystem.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    UserService userService;

    @Autowired
    TableRepository tableRepository;

    @Autowired
    TableService tableService;

    @Autowired
    TaskListRepository taskListRepository;

    @Autowired
    TaskService taskService;

    @Autowired
    TaskListService taskListService;

    @GetMapping("/test1")
    @ResponseBody
    public void getTest(){
        taskListService.setRelationBetweenTasks(20,21);
    }

    @GetMapping("/test2")
    @ResponseBody
    public List<Group> getTest2(){
        System.out.println(userService.getUserById(2).getTables());
        return userService.getUserById(2).getGroups();
    }
}
