package com.techbridge24.backend.model;

import org.springframework.stereotype.Component;

@Component
public class Users {
    private int id;
    private String name;
    private String email;
    private String pass;
    private String role;

    public Users() {
    }

    public Users(int id, String name, String email, String pass, String role) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
