package mainSystem.model.userInitModels;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users",schema = "main")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name= "password")
    private String password;
    @Column(name = "email")
    private String email;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "users_and_table", schema = "main",
            joinColumns = {@JoinColumn(name = "id_users")},
            inverseJoinColumns = {@JoinColumn(name = "id_table")}
    )
    @JsonIgnore
    private Set<mainSystem.model.taskUnitModels.Table> tables = new HashSet<mainSystem.model.taskUnitModels.Table>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "usersandgroup", schema = "main",
            joinColumns = {@JoinColumn(name = "userid")},
            inverseJoinColumns = {@JoinColumn(name = "groupid")}
    )
    @JsonIgnore
    private List<Group> groups = new LinkedList<Group>();


    public User() {
    }

    public User(String username,String password){
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<mainSystem.model.taskUnitModels.Table> getTables() {
        return tables;
    }

    public void setTables(Set<mainSystem.model.taskUnitModels.Table> tables) {
        this.tables = tables;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", groups=" + groups +
                '}';
    }
}
