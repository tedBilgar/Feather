package mainSystem.model.taskUnitModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

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
    private Integer assignedgroupid;

    @Column(name = "assignedusersid")
    private Integer assigneduserid;

    @ManyToOne
    @JoinColumn(name = "id_table")
    @JsonIgnore
    private mainSystem.model.taskUnitModels.Table taskTable;

    @OneToMany(mappedBy = "taskList")
    @JsonIgnore
    private Set<Task> tasks = new HashSet<Task>();

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

    public Integer getAssignedgroupid() {
        return assignedgroupid;
    }

    public void setAssignedgroupid(Integer assignedgroupid) {
        this.assignedgroupid = assignedgroupid;
    }

    public Integer getAssigneduserid() {
        return assigneduserid;
    }

    public void setAssigneduserid(Integer assigneduserid) {
        this.assigneduserid = assigneduserid;
    }

    public mainSystem.model.taskUnitModels.Table getTaskTable() {
        return taskTable;
    }

    public void setTaskTable(mainSystem.model.taskUnitModels.Table taskTable) {
        this.taskTable = taskTable;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
