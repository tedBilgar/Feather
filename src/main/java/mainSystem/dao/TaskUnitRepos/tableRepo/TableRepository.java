package mainSystem.dao.TaskUnitRepos.tableRepo;

import mainSystem.model.taskUnitModels.Table;

import java.util.List;

public interface TableRepository {
    Table getTableById(int id);
    Table getTableByName(String name);
    List<Table> getAllTables();
    Table addTable(Table table);
    void setTable(Table table);
    void deleteTable(int tableId);
}
