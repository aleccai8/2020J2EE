package com.homework.homework3.controller;

import com.homework.homework3.pojo.dto.PersonDTO;
import com.homework.homework3.pojo.po.Admin;
import com.homework.homework3.pojo.vo.AddPersonRequestVo;
import com.homework.homework3.pojo.vo.DeletePersonRequestVo;
import com.homework.homework3.pojo.vo.EditPersonRequestVo;
import com.homework.homework3.pojo.vo.LoginRequestVo;
import com.homework.homework3.service.AdminService;
import com.homework.homework3.service.PersonService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengheng7913
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final Map<String, Integer> tokens;

    @Autowired
    AdminService adminService;

    @Autowired
    PersonService personService;

    public AdminController(){
        tokens = new HashMap<>();
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(LoginRequestVo loginRequestVo){
        Admin admin = adminService.getAdmin(loginRequestVo.getUsername());
        Map<String,Object> map = new HashMap<>();
        if(admin != null && admin.getPassword().equals(loginRequestVo.getPassword())){
            String token = RandomStringUtils.randomAlphanumeric(5);
            tokens.put(token,admin.getId());
            map.put("success",true);
            map.put("message","登录成功");
            map.put("token",token);
        }else{
            map.put("success",false);
            map.put("message","登录失败");
        }
        return ResponseEntity.status(200).body(map);
    }

    @PostMapping("/addPerson")
    public ResponseEntity<Map<String,Object>> addPerson(AddPersonRequestVo requestVo, BindingResult bindingResult){
        Map<String,Object> map = new HashMap<>();
        if(bindingResult.hasErrors()){
            map.put("message","添加失败");
            map.put("errors",bindingResult.getFieldErrors());
            return ResponseEntity.status(400).body(map);
        }
        if(tokens.get(requestVo.getToken()) == null){
            map.put("message","请先登录");
            return ResponseEntity.status(401).body(map);
        }
        PersonDTO personDTO = new PersonDTO(requestVo);
        try{
            personService.addPerson(personDTO);
            map.put("message","添加成功");

        }catch (RuntimeException runtimeException){
            map.put("message",runtimeException.getMessage());
        }
        return ResponseEntity.status(200).body(map);
    }


    @PostMapping("/deletePerson")
    public ResponseEntity<Map<String,Object>> deletePerson(DeletePersonRequestVo requestVo,BindingResult bindingResult){
        Map<String,Object> map = new HashMap<>();
        if(bindingResult.hasErrors()){
            map.put("message","删除失败");
            map.put("errors",bindingResult.getFieldErrors());
            return ResponseEntity.status(400).body(map);
        }
        if(tokens.get(requestVo.getToken()) == null){
            map.put("message","请先登录");
            return ResponseEntity.status(401).body(map);
        }
        try{
            personService.deletePeron(requestVo.getId());
            map.put("message","删除成功");
        }catch (RuntimeException runtimeException){
            map.put("message",runtimeException.getMessage());
        }
        return ResponseEntity.status(200).body(map);
    }

    @PostMapping("/editPerson")
    public ResponseEntity<Map<String,Object>> editPerson(EditPersonRequestVo requestVo,BindingResult bindingResult){
        Map<String,Object> map = new HashMap<>();
        if(bindingResult.hasErrors()){
            map.put("message","编辑失败");
            map.put("errors",bindingResult.getFieldErrors());
            return ResponseEntity.status(400).body(map);
        }
        if(tokens.get(requestVo.getToken()) == null){
            map.put("message","请先登录");
            return ResponseEntity.status(401).body(map);
        }
        PersonDTO personDTO = new PersonDTO(requestVo);
        try{
            personService.editPerson(personDTO);
            map.put("message","修改成功");
        }catch (RuntimeException runtimeException){
            map.put("message",runtimeException.getMessage());
        }
        return ResponseEntity.status(200).body(map);
    }


}
