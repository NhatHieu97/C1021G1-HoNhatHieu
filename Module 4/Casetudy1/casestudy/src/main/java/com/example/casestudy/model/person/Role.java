package com.example.casestudy.model.person;

import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<UserName> users;

    public Role() {
    }

    public Role(Long id, String name, Set<UserName> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserName> getUsers() {
        return users;
    }

    public void setUsers(Set<UserName> users) {
        this.users = users;
    }
}
