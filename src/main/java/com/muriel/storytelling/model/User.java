package com.muriel.storytelling.model;


import java.io.Serializable;
import java.util.Objects;


public class User implements Serializable
{
    private String id;
    private String password;
    private String username;



    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return id.equals(user.id) && Objects.equals(password, user.password) && Objects.equals(username, user.username);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}