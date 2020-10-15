package com.homework.homework4.pojo.vo;

import com.homework.homework4.pojo.po.Person;

import java.util.LinkedList;
import java.util.List;

public class SearchResponseVo {

    private String id;

    private String name;

    private String phone;

    private String qq;

    private String email;

    public SearchResponseVo(Person person){
        this.id = person.getId();
        this.name = person.getName();
        this.phone = person.getPhone();
        this.qq = person.getQq();
        this.email = person.getEmail();
    }

    public static List<SearchResponseVo> fromList(List<Person> listPerson){
        List<SearchResponseVo> searchResponseVoList = new LinkedList<>();
        for(Person person : listPerson){
            searchResponseVoList.add(new SearchResponseVo(person));
        }
        return searchResponseVoList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

}
