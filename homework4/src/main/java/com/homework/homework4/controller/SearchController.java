package com.homework.homework4.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baidu.aip.face.AipFace;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.homework.homework4.pojo.vo.SearchFaceRequestVo;
import com.homework.homework4.pojo.vo.SearchRequestVo;
import com.homework.homework4.pojo.vo.SearchResponseVo;
import com.homework.homework4.service.AipFaceService;
import com.homework.homework4.service.SearchService;
import com.homework.homework4.utils.Base64;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengheng7913
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @Autowired
    AipFaceService aipFaceService;

    @PostMapping
    public ResponseEntity<List<SearchResponseVo>> search(SearchRequestVo requestVo){
        return ResponseEntity.status(200).body(SearchResponseVo.fromList(searchService.findPerson(requestVo.getOption(),requestVo.getParam(),requestVo.getPage())));
    }

    @PostMapping("/face")
    public Object searchByFace(@Valid SearchFaceRequestVo requestVo, BindingResult bindingResult) throws IOException {
        Map<String,Object> map = new HashMap<>();
        if(bindingResult.hasErrors()){
            map.put("message","搜索失败");
            map.put("errors",bindingResult.getFieldErrors());
            return ResponseEntity.status(400).body(map);
        }
        AipFace aipFace = aipFaceService.getAipFace();
        String base64 = Base64.pictureEncode(requestVo.getFile());
        HashMap<String, String> options = new HashMap<>();
        options.put("match_threshold", "70");
        JSONObject jsonObject = aipFace.search(base64,"BASE64","person",options);;
        if(jsonObject.get("result").equals(null)){
            map.put("message",jsonObject.getString("error_msg"));
            return ResponseEntity.status(200).body(map);
        }else{
            System.out.println(jsonObject);
            JSONObject result = (JSONObject) jsonObject.get("result");
            JSONObject user = (JSONObject) result.getJSONArray("user_list").get(0);
            String id =user.getString("user_id");
            return ResponseEntity.status(200).body(SearchResponseVo.fromList(searchService.findPerson("id",id)));

        }
    }
}
