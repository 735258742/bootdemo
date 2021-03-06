package com.example.demo.bean;

public class User {
    private String userid;
    private String username;
    private String password;
    private String isroot;

    public User(String userid, String username, String password, String isroot) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.isroot = isroot;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public String getIsroot() {
        return isroot;
    }

    public void setIsroot(String isroot) {
        this.isroot = isroot;
    }
}
