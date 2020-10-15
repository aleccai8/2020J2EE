package com.homework.homework4.service.impl;

import com.homework.homework4.mapper.PersonMapper;
import com.homework.homework4.pojo.po.Person;
import com.homework.homework4.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhengheng7913
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    PersonMapper personMapper;

    private static int PER_PAGE = 1;

    @Override
    public List<Person> findPerson(String option, String param) {
        return findPerson(option,param,-1);
    }

    @Override
    public List<Person> findPerson(String option, String param,int page) {
        if ("id".equals(option)) {
            List<Person> list = new LinkedList<Person>();
            list.add(personMapper.findById(param));
            return list;
        } else if ("name".equals(option)) {
            if(page == 0){
                return personMapper.findLikeUsername("%"+param+"%",0,PER_PAGE);

            }else{
                return personMapper.findLikeUsername("%"+param+"%",page * PER_PAGE - 1, PER_PAGE);
            }
        } else if ("phone".equals(option)) {
            List<Person> list = new LinkedList<Person>();
            list.add(personMapper.findByPhone(param));
            return list;
        } else if ("qq".equals(option)) {
            List<Person> list = new LinkedList<Person>();
            list.add(personMapper.findByQq(param));
            return list;
        } else if ("email".equals(option)) {
            List<Person> list = new LinkedList<Person>();
            list.add(personMapper.findByEmail(param));
            return list;
        }
        return null;
    }
}
