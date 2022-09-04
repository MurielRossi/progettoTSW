package com.muriel.storytelling.model;


import java.io.Serializable;
import java.util.Objects;


public class User implements Serializable
{
    private String email;
    private String password;
    private String username;
    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return email.equals(user.email) && Objects.equals(password, user.password) && Objects.equals(username, user.username);
    }

    public User(String username, String password,String email) {
        this.password = password;
        this.username = username;
        this.email = email;
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
}