package com.j2ee.homework1.servlet.data;

public class PeopleExcelDataVO {
    private String id;

    private String name;

    private String phone;

    private String email;

    private String qq;

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}

