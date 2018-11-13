package mainSystem.service.tableService;

import mainSystem.model.taskUnitModels.Table;
import mainSystem.model.userInitModels.User;

import java.util.List;
import java.util.Set;

public interface TableService {
    Table getTableById(int id);
    Table getTableByName(String name);
    List<Table> getAllTables();
    void addTable(Table table);
    void setTable(Table table);
    void deleteTable(int tableId);
    Set<User> getUserSetOfTable(int id);
 }
