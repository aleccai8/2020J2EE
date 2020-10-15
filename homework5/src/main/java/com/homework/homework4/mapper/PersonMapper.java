package com.homework.homework4.mapper;

import com.homework.homework4.pojo.po.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhengheng7913
 */
@Repository
@Mapper
public interface PersonMapper {

    Person findById(String id);

    List<Person> findLikeUsername(String name,int startIndex,int count);

    Person findByPhone(String phone);

    Person findByQq(String qq);

    Person findByEmail(String email);

    Person findByName(String name);

    List<Person> findByIdOrPhone(String id,String phone);

    void insert(String id,String name,String phone,String qq,String email);

    void delete(String id);

    void update(String id,String name,String phone,String qq,String email);

}
