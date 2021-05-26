package com.myspringboot.example.dao;

import com.myspringboot.example.model.Comment;
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
@Qualifier("commentDao")
public class CommentDAOImpl implements DAO<Comment >{

    private static final Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
    private JdbcTemplate jdbcTemplate;

    RowMapper<Comment> rowMapper = (rs, rowNum) -> {
        Comment comment = new Comment();
        comment.setIssueKey(rs.getString("issueKey"));
        comment.setText(rs.getString("text"));
        comment.setAuthor(rs.getString("author"));
        comment.setCreated(rs.getTimestamp("created"));
        return comment;
    };

    public CommentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Page<Comment> list(String issueKey, Pageable pageable) {
        String rowCountSql = "SELECT count(1) AS row_count FROM Comment where issueKey = ?;";
        int total =
                jdbcTemplate.queryForObject(
                        rowCountSql, new Object[]{issueKey}, (rs, rowNum) -> rs.getInt(1)
                );

        String sql = "SELECT issueKey, text, author, created " +
                "FROM Comment " +
                "where issueKey = ? " +
                "LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
        List<Comment> comments = jdbcTemplate.query(sql, new Object[]{issueKey}, rowMapper);
        return new PageImpl<>(comments, pageable, total);
    }

    @Override
    public Optional<Comment> get(Long id) {
        String sql = "SELECT issueKey, text, author, created FROM Comment where id = ?";
        Comment comment = null;

        try{
            comment = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (DataAccessException ex) {
            log.error("Comment not found for ID " + id);
        }
        return Optional.ofNullable(comment);
    }
}
