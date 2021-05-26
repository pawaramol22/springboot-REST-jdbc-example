package com.myspringboot.example.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DAO<T> {
    Page<T> list(String issueKey, Pageable pageable);

    Optional<T> get(Long id);

}
