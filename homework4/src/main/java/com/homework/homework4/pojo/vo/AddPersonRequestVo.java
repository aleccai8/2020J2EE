package com.homework.homework4.pojo.vo;


import javax.validation.constraints.NotEmpty;

/**
 * @author zhengheng7913
 */
public class AddPersonRequestVo {

    @NotEmpty(message = "token不能为空")
    private String token;

    @NotEmpty(message = "学号/教工号不能为空")
    private String id;

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotEmpty(message = "电话不能为空")
    private String phone;

    private String qq;

    private String email;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getQq() {
        return qq;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AddPersonRequest{" +
                "token='" + token + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
