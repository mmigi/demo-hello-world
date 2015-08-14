package com.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model class of user
 * consists of name and password
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_name", unique = true,
            nullable = false)
    protected String name;

    @Column(name = "user_password", nullable = false)
    protected String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
