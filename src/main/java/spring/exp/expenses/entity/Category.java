package spring.exp.expenses.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="new_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique=true)
    private String name;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    private boolean active;
    private LocalDateTime dateCreated;

    public Category() {
    }

    public Category(String name, User user, boolean active) {
        this.name = name;
        this.user = user;
        this.active = active;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
