package com.myspringboot.example.dao;

import com.myspringboot.example.model.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Component
@Qualifier("componentDao")
public class ComponentDAOImpl implements DAO<Component >{

    private static final Logger log = LoggerFactory.getLogger(ComponentDAOImpl.class);
    private JdbcTemplate jdbcTemplate;

    RowMapper<Component> rowMapper = (rs, rowNum) -> {
        Component label = new Component();
        label.setIssueKey(rs.getString("issueKey"));
        label.setName(rs.getString("name"));
        return label;
    };

    public ComponentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Page<Component> list(String issueKey, Pageable pageable) {
        String rowCountSql = "SELECT count(1) AS row_count FROM Component where issueKey = ?;";
        int total =
                jdbcTemplate.queryForObject(
                        rowCountSql, new Object[]{issueKey}, (rs, rowNum) -> rs.getInt(1)
                );

        String sql = "SELECT issueKey, name " +
                "FROM Component " +
                "where issueKey = ? " +
                "LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
        List<Component> components = jdbcTemplate.query(sql, new Object[]{issueKey}, rowMapper);
        return new PageImpl<>(components, pageable, total);
    }

    @Override
    public Optional<Component> get(Long id) {
        String sql = "SELECT issueKey, name FROM Component where id = ?";
        Component component = null;

        try{
            component = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (DataAccessException ex) {
            log.error("Component not found for ID " + id);
        }
        return Optional.ofNullable(component);
    }
}
