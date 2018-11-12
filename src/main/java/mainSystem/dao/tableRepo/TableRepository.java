package mainSystem.dao.tableRepo;

import mainSystem.model.taskUnitModels.Table;

public interface TableRepository {
    Table getTableById(int id);
    Table getTableByName(String name);
    void addTable(Table table);
    void setTable(Table table);
    void deleteTable(int tableId);
}
