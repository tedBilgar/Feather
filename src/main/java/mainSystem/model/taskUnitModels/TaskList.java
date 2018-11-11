package mainSystem.model.taskUnitModels;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "task_list",schema = "main")
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "id_table")
    private int id_table;

    @Column(name = "assignedgroupid")
    private int assignedgroupid;

    @Column(name = "assigneduserid")
    private int assigneduserid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_table() {
        return id_table;
    }

    public void setId_table(int id_table) {
        this.id_table = id_table;
    }

    public int getAssignedgroupid() {
        return assignedgroupid;
    }

    public void setAssignedgroupid(int assignedgroupid) {
        this.assignedgroupid = assignedgroupid;
    }

    public int getAssigneduserid() {
        return assigneduserid;
    }

    public void setAssigneduserid(int assigneduserid) {
        this.assigneduserid = assigneduserid;
    }
}