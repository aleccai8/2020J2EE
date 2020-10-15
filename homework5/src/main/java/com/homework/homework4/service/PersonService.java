package com.homework.homework4.service;

import com.homework.homework4.pojo.dto.PersonDTO;

import java.util.Map;

/**
 * @author zhengheng7913
 */
public interface PersonService {
    void addPerson(PersonDTO personDTO);

    void deletePeron(String id);

    void editPerson(PersonDTO personDTO);

    Map<String, String> getPersonToken();
}
