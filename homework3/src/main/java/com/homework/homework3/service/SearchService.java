package com.homework.homework3.service;

import com.homework.homework3.pojo.po.Person;

import java.util.List;

/**
 * @author zhengheng7913
 */
public interface SearchService {

    List<Person> findPerson(String column,String param);

    List<Person> findPerson(String column,String param,int page);
}
