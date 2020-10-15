package com.homework.homework3.pojo.po;

/**
 * @author zhengheng7913
 */
public class Admin {
    
    private int Id;
    
    private String username;
    
    private String password;

    public void setId(int id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return Id;
    }
    
    
}
