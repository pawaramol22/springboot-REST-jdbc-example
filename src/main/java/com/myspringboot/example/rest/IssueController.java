package com.myspringboot.example.rest;

import com.myspringboot.example.dao.IssueDAO;
import com.myspringboot.example.exceptions.ResourceNotFoundException;
import com.myspringboot.example.model.Issue;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/2")
public class IssueController {

    @Autowired
    private IssueDAO issueDao;

    @GetMapping("/search")
    public Page<Issue> all(@RequestParam(required = true) String projectKey, Pageable pageable) {
        return issueDao.list(projectKey, pageable);
    }

    @GetMapping("/issue/{key}")
    public Issue one(@PathVariable String key) throws Throwable {
        return (Issue)issueDao.get(key).orElseThrow(() -> new ResourceNotFoundException(key));
    }
}
