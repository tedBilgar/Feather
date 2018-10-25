package mainSystem.model.taskUnitModels;

import java.util.Date;

public class Task {
    private int id;
    private String name;
    private int priority;
    private int effort;
    private String[] dependencyList;
    private boolean isDone;
    private Date timeStamp;
    private String label;
    private String userInfo;

    //TODO
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public String[] getDependencyList() {
        return dependencyList;
    }

    public void setDependencyList(String[] dependencyList) {
        this.dependencyList = dependencyList;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
