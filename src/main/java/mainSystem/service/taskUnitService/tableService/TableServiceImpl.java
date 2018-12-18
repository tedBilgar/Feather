package mainSystem.service.taskUnitService.tableService;

import mainSystem.dao.TaskUnitRepos.tableRepo.TableRepository;
import mainSystem.model.taskUnitModels.Table;
import mainSystem.model.taskUnitModels.TaskList;
import mainSystem.model.userInitModels.User;
import mainSystem.service.taskUnitService.taskListService.TaskListService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class TableServiceImpl implements TableService{
    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private TaskListService taskListService;

    public Table getTableById(int id) {
        return tableRepository.getTableById(id);
    }

    public Table getTableByName(String name) {
        return tableRepository.getTableByName(name);
    }

    public List<Table> getAllTables() {
        return tableRepository.getAllTables();
    }

    public void addTable(Table table) {
        tableRepository.addTable(table);
    }

    public void setTable(Table table) {
        tableRepository.setTable(table);
    }

    public void deleteTable(int tableId) {
        tableRepository.deleteTable(tableId);
    }

    @Transactional
    public Set<User> getUserSetOfTable(int id) {
        Set<User> userSet = tableRepository.getTableById(id).getUserSet();
        Hibernate.initialize(userSet);
        return userSet;
    }

    public TaskList addTaskList(TaskList taskList, int tableID) {
        taskList.setTaskTable(tableRepository.getTableById(tableID));
        taskListService.addTaskList(taskList);
        return taskList;
    }

    @Transactional
    public TaskList getTaskList(int taskListID) {
        TaskList taskList = taskListService.getTaskListById(taskListID);
        Hibernate.initialize(taskList);
        return taskList;
    }

    @Transactional
    public Set<TaskList> getAllTaskListOfTable(int tableID) {
        Table table = tableRepository.getTableById(tableID);
        Set<TaskList> taskList = table.getTaskLists();
        Hibernate.initialize(taskList);
        return taskList;
    }

    public void mergeTables(int old_tableID, int new_tableID) {
        Table old_table = tableRepository.getTableById(old_tableID);
        Table new_table = tableRepository.getTableById(new_tableID);

        for (TaskList tasklist: old_table.getTaskLists()) {
            tasklist.setTaskTable(new_table);
            taskListService.setTaskList(tasklist);
        }
    }
}
