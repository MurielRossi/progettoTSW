package com.muriel.storytelling.model;


import java.io.Serializable;
import java.util.Objects;


public class User implements Serializable
{
    private String email;
    private String password;
    private String username;
    private boolean isAdmin;
    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return email.equals(user.email) && Objects.equals(password, user.password) && Objects.equals(username, user.username)&& isAdmin == user.isAdmin;
    }

    public User(String username, String password,String email, boolean isAdmin) {
        this.password = password;
        this.username = username;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public User() {
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

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}