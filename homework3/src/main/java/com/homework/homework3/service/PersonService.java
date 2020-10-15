package com.homework.homework3.service;

import com.homework.homework3.pojo.dto.PersonDTO;

/**
 * @author zhengheng7913
 */
public interface PersonService {
    void addPerson(PersonDTO personDTO);

    void deletePeron(String id);

    void editPerson(PersonDTO personDTO);
}
