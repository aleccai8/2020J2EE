package com.homework.homework3.service.impl;

import com.homework.homework3.mapper.PersonMapper;
import com.homework.homework3.pojo.dto.PersonDTO;
import com.homework.homework3.pojo.po.Person;
import com.homework.homework3.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonMapper personMapper;

    @Override
    public void addPerson(PersonDTO personDTO) {
        List<Person> list = personMapper.findByIdOrPhone(personDTO.getId(),personDTO.getPhone());
        if(list.size() != 0){
            throw new RuntimeException("学号/教工号或电话号码重复");
        }
        personMapper.insert(personDTO.getId(),personDTO.getName(),personDTO.getPhone(),personDTO.getQq(),personDTO.getEmail());
    }

    @Override
    public void deletePeron(String id) {
        Person person = personMapper.findById(id);
        if(person == null){
            throw new RuntimeException("该学生/教师不存在");
        }
        personMapper.delete(id);
    }

    @Override
    public void editPerson(PersonDTO personDTO) {

        Person person = personMapper.findById(personDTO.getId());
        if(person == null){
            throw new RuntimeException("该学生/教师不存在");
        }
        if(personDTO.getName()!=null && personMapper.findByName(personDTO.getName()) != null){
            throw new RuntimeException("姓名已被占用");
        }
        String name =  personDTO.getName()!=null?personDTO.getName(): person.getName();
        String phone = personDTO.getPhone()!=null?personDTO.getPhone(): person.getPhone();
        String qq = personDTO.getQq()!=null?personDTO.getQq(): person.getQq();
        String email = personDTO.getEmail()!=null?personDTO.getEmail(): person.getEmail();
        personMapper.update(person.getId(),name,phone,qq,email);

    }
}
