package com.myspringboot.example.dao;

import com.myspringboot.example.model.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IssueDAO<T> {
    Page<T> list(Pageable pageable);

    Optional<T> get(String issueKey);

}
