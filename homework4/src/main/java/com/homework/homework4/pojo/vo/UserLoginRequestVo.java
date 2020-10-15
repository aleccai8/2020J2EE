package com.homework.homework4.pojo.vo;

/**
 * @author zhengheng7913
 */
public class UserLoginRequestVo {
    private String id;

    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserLoginRequestVo{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
