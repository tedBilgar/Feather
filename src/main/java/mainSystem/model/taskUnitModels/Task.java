package mainSystem.model.taskUnitModels;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "task",schema = "main")
public class Task {
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

    @Column(name = "isdone")
    private boolean isDone;

    @ManyToOne
    @JoinColumn(name = "id_list")
    @JsonIgnore
    private TaskList taskList;

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

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    /*private String name;
    private int priority;
    private int effort;
    private String[] dependencyList;
    private boolean isDone;
    private Date timeStamp;
    private String label;
    private String userInfo;
*/

}
