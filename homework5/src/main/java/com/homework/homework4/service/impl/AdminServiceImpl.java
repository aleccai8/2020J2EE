package com.homework.homework4.service.impl;

import com.homework.homework4.mapper.AdminMapper;
import com.homework.homework4.pojo.po.Admin;
import com.homework.homework4.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengheng7913
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin getAdmin(String username) {
        return adminMapper.getByUsername(username);
    }
}
