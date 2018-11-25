package mainSystem.model.taskUnitModels;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable( name = "taskrelation",schema = "main",
            joinColumns = @JoinColumn(name = "id_task",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_parent",referencedColumnName = "id"))
    @JsonIgnore
    private List<Task> taskRelation = new ArrayList<Task>();

    @Transient
    private List<Integer> dependencyID = new ArrayList<Integer>();

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

    public List<Task> getTaskRelation() {
        return taskRelation;
    }

    public void setTaskRelation(List<Task> taskRelation) {
        this.taskRelation = taskRelation;
    }

    public List<Integer> getDependencyID() {
        return dependencyID;
    }

    public void setDependencyID(List<Integer> dependencyID) {
        this.dependencyID = dependencyID;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", taskRelation=" + taskRelation +
                '}';
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
