package com.homework.homework4.pojo.dto;

import com.homework.homework4.pojo.vo.AddPersonRequestVo;
import com.homework.homework4.pojo.vo.EditPersonRequestVo;

/**
 * @author zhengheng7913
 */
public class PersonDTO {
    private String id;

    private String name;

    private String phone;

    private String qq;

    private String email;

    public PersonDTO(AddPersonRequestVo vo){
        id = vo.getId();
        name = vo.getName();
        phone = vo.getPhone();
        qq = vo.getQq();
        email = vo.getEmail();
    }

    public PersonDTO(EditPersonRequestVo vo){
        id = vo.getId();
        name = vo.getName();
        phone = vo.getPhone();
        qq = vo.getQq();
        email = vo.getEmail();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQq() {
        return qq;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
