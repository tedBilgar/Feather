package mainSystem.model.taskUnitModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mainSystem.model.userInitModels.User;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "table",schema = "main")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @Column(columnDefinition = "name")
    private String name;

    @Column(columnDefinition = "typeid")
    private Integer typeid;

    @Column(columnDefinition = "scrumid")
    private Integer scrumid;

    @Column(columnDefinition = "kanbanid")
    private Integer kanbanid;

    @ManyToMany(mappedBy = "tables")
    @JsonIgnore
    private Set<User> userSet = new HashSet<User>();

    @OneToMany(mappedBy = "taskTable", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<TaskList> taskLists = new HashSet<TaskList>();

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

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getScrumid() {
        return scrumid;
    }

    public void setScrumid(Integer scrumid) {
        this.scrumid = scrumid;
    }

    public Integer getKanbanid() {
        return kanbanid;
    }

    public void setKanbanid(Integer kanbanid) {
        this.kanbanid = kanbanid;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Set<TaskList> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(Set<TaskList> taskLists) {
        this.taskLists = taskLists;
    }
}
