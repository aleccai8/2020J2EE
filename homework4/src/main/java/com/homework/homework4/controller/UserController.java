package com.homework.homework4.controller;

import com.baidu.aip.face.AipFace;
import com.homework.homework4.pojo.po.Person;
import com.homework.homework4.pojo.vo.UserLoginRequestVo;
import com.homework.homework4.pojo.vo.UserPhotoUploadRequestVo;
import com.homework.homework4.service.AipFaceService;
import com.homework.homework4.service.PersonService;
import com.homework.homework4.service.SearchService;
import com.homework.homework4.utils.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengheng7913
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final Map<String, String> tokens;

    @Autowired
    private PersonService personService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private AipFaceService aipFaceService;

    public UserController(){
        tokens = new HashMap<>();
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@Valid UserLoginRequestVo requestVo, BindingResult bindingResult){
        Map<String,Object> map = new HashMap<>();
        if(bindingResult.hasErrors()){
            map.put("message","登录失败");
            map.put("errors",bindingResult.getFieldErrors());
            return ResponseEntity.status(400).body(map);
        }
        Person person = searchService.findPerson("id",requestVo.getId()).get(0);
        if(person == null){
            map.put("message","用户不存在");
            return ResponseEntity.status(200).body(map);
        }
        if(person.getPassword() != null && !person.getPassword().equals(requestVo.getPassword())){
            map.put("message","用户名或密码错误");
            return ResponseEntity.status(200).body(map);
        }
        String token = RandomStringUtils.randomAlphanumeric(5);
        tokens.put(token,person.getId());
        map.put("message","用户登录成功");
        map.put("token",token);
        return ResponseEntity.status(200).body(map);
    }

    @PostMapping("/uploadPhoto")
    public Object uploadPhoto(@Valid UserPhotoUploadRequestVo requestVo,BindingResult bindingResult) throws IOException {
        Map<String,Object> map = new HashMap<>();
        if(bindingResult.hasErrors()){
            map.put("message","照片上传失败");
            map.put("errors",bindingResult.getFieldErrors());
            return ResponseEntity.status(400).body(map);
        }
        if(tokens.get(requestVo.getToken()) == null){
            map.put("message","请先登录");
            return ResponseEntity.status(401).body(map);
        }
        String id = tokens.get(requestVo.getToken());
        AipFace aipFace = aipFaceService.getAipFace();
        String base64 = Base64.pictureEncode(requestVo.getFile());
        Person person = searchService.findPerson("id",id).get(0);
        JSONObject jsonObject = aipFace.addUser(base64,"BASE64","person",person.getId(),null);
        if(jsonObject.get("error_msg") == "SUCCESS"){
            map.put("message","上传成功");
        }else{
            map.put("message",jsonObject.get("error_msg"));
        }
        return ResponseEntity.status(200).body(map);

    }


}
