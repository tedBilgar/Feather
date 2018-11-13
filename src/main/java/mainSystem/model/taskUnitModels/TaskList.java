package mainSystem.model.taskUnitModels;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "assignedgroupid")
    private int assignedgroupid;

    @Column(name = "assigneduserid")
    private int assigneduserid;

    @ManyToOne
    @JoinColumn(name = "id_table")
    @JsonIgnore
    private mainSystem.model.taskUnitModels.Table taskTable;

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

    public mainSystem.model.taskUnitModels.Table getTaskTable() {
        return taskTable;
    }

    public void setTaskTable(mainSystem.model.taskUnitModels.Table taskTable) {
        this.taskTable = taskTable;
    }
}
