package com.homework.homework3.mapper;

import com.homework.homework3.pojo.po.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminMapper {
    Admin getByUsername(String username);
}
