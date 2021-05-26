package com.myspringboot.example.rest;

import com.myspringboot.example.dao.JiraDAO;
import com.myspringboot.example.exceptions.ResourceNotFoundException;
import com.myspringboot.example.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/2")
public class IssueController {

    @Autowired
    private JiraDAO dao;

    @GetMapping("/search")
    public Page<Issue> all(Pageable pageable) {
        return dao.list(pageable);
    }

    @GetMapping("/issue/{key}")
    public Issue one(@PathVariable String key) throws Throwable {
        return (Issue)dao.get(key).orElseThrow(() -> new ResourceNotFoundException(key));
    }
}
