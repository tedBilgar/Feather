package mainSystem.dao.tableRepo;

import mainSystem.dao.userRepository.UserRepository;
import mainSystem.model.taskUnitModels.Table;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public class TableRepositoryImpl implements TableRepository{
    private static final Logger logger = Logger.getLogger(TableRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSessionFactory(){
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public Table getTableById(int id) {
        logger.info("Getting table By ID " + id);
        Table table = (Table) getCurrentSessionFactory().createQuery("from Table t where t.id =: id ").setParameter("id",id).uniqueResult();
        if (table == null){
            logger.error("No found table " + id);
            return null;
        }
        return table;
    }

    @Transactional
    public Table getTableByName(String name) {
        logger.info("Getting table By name " + name);
        Table table = (Table) getCurrentSessionFactory().createQuery("from Table t where t.name =: name ").setParameter("name",name).uniqueResult();
        if (table == null){
            logger.error("No found table " + name);
            return null;
        }
        return table;
    }

    @Transactional
    public List<Table> getAllTables(){
        List<Table> tables = getCurrentSessionFactory().createQuery("from Table t").list();
        return tables;
    }

    @Transactional
    public Table addTable(Table table) {
        logger.info("Adding table");
        getCurrentSessionFactory().save(table);
        return table;
    }

    @Transactional
    public void setTable(Table table) {
        logger.info("Setting table");
        getCurrentSessionFactory().update(table);
    }

    @Transactional
    public void deleteTable(int tableId) {
        logger.info("Deleting table " + tableId);
        Table table = (Table) getCurrentSessionFactory().createQuery("from Table t where t.id =: id ").setParameter("id",tableId).uniqueResult();
        if (table == null){
            logger.error("No found table " + tableId);
        }
        getCurrentSessionFactory().delete(table);
    }
}
