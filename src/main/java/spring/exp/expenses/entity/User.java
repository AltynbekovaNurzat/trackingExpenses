package spring.exp.expenses.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="new_user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String login;
    private String password;
    private Boolean blocked;
    private LocalDateTime dateCreated;

    public User() {
    }

    public User(String name, String login, String password, Boolean blocked) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.blocked = blocked;
        this.dateCreated = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
