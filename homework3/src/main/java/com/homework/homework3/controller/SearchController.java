package com.homework.homework3.controller;

import com.homework.homework3.pojo.po.Person;
import com.homework.homework3.pojo.vo.SearchRequestVo;
import com.homework.homework3.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhengheng7913
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @PostMapping
    public ResponseEntity<List<Person>> search(SearchRequestVo requestVo){
        return ResponseEntity.status(200).body(searchService.findPerson(requestVo.getOption(),requestVo.getParam(),requestVo.getPage()));
    }
}
