package mainSystem.model.taskUnitModels;

import javax.persistence.*;

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
    private int typeid;

    @Column(columnDefinition = "scrumid")
    private int scrumid;

    @Column(columnDefinition = "kanbanid")
    private int kanbanid;

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

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getScrumid() {
        return scrumid;
    }

    public void setScrumid(int scrumid) {
        this.scrumid = scrumid;
    }

    public int getKanbanid() {
        return kanbanid;
    }

    public void setKanbanid(int kanbanid) {
        this.kanbanid = kanbanid;
    }
}