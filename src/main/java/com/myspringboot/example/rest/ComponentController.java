package com.myspringboot.example.rest;

import com.myspringboot.example.dao.DAO;
import com.myspringboot.example.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/2")
public class ComponentController {

    @Autowired
    @Qualifier("componentDao")
    private DAO dao;

    @GetMapping("/issue/{key}/components")
    public Page<Issue> all(@PathVariable String key, Pageable pageable) {
        return dao.list(key, pageable);
    }
}
