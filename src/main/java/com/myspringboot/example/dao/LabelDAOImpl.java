package com.myspringboot.example.dao;

import com.myspringboot.example.model.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Qualifier("labelDao")
public class LabelDAOImpl implements DAO<Label >{

    private static final Logger log = LoggerFactory.getLogger(LabelDAOImpl.class);
    private JdbcTemplate jdbcTemplate;

    RowMapper<Label> rowMapper = (rs, rowNum) -> {
        Label label = new Label();
        label.setIssueKey(rs.getString("issueKey"));
        label.setName(rs.getString("name"));
        return label;
    };

    public LabelDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Page<Label> list(String issueKey, Pageable pageable) {
        String rowCountSql = "SELECT count(1) AS row_count FROM Label where issueKey = ?;";
        int total =
                jdbcTemplate.queryForObject(
                        rowCountSql, new Object[]{issueKey}, (rs, rowNum) -> rs.getInt(1)
                );

        String sql = "SELECT issueKey, name " +
                "FROM Label " +
                "where issueKey = ? " +
                "LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
        List<Label> labels = jdbcTemplate.query(sql, new Object[]{issueKey}, rowMapper);
        return new PageImpl<>(labels, pageable, total);
    }

    @Override
    public Optional<Label> get(Long id) {
        String sql = "SELECT issueKey, name FROM Label where id = ?";
        Label label = null;

        try{
            label = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (DataAccessException ex) {
            log.error("Label not found for ID " + id);
        }
        return Optional.ofNullable(label);
    }
}
