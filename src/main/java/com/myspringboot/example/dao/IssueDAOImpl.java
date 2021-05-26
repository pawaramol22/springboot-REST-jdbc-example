package com.myspringboot.example.dao;

import com.myspringboot.example.model.Issue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class IssueDAOImpl implements IssueDAO<Issue > {

    private static final Logger log = LoggerFactory.getLogger(IssueDAOImpl.class);
    private JdbcTemplate jdbcTemplate;

    RowMapper<Issue> rowMapper = (rs, rowNum) -> {
        Issue issue = new Issue();
        issue.setIssueKey(rs.getString("issueKey"));
        issue.setProjectKey(rs.getString("projectKey"));
        issue.setIssueType(rs.getString("type"));
        issue.setDescription(rs.getString("description"));
        issue.setSummary(rs.getString("summary"));
        issue.setPriority(rs.getString("priority"));
        issue.setAssignee(rs.getString("assignee"));
        issue.setReporter(rs.getString("reporter"));
        issue.setState(rs.getString("state"));
        return issue;
    };

    public IssueDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Page<Issue> list(Pageable pageable) {
        String rowCountSql = "SELECT count(1) AS row_count FROM Issue;";
        int total =
                jdbcTemplate.queryForObject(
                        rowCountSql, (rs, rowNum) -> rs.getInt(1)
                );

        String sql = "SELECT issueKey, projectKey, type, summary, description, priority, assignee, reporter, state FROM Issue LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();
        List<Issue> issues = jdbcTemplate.query(sql, rowMapper);
        return new PageImpl<>(issues, pageable, total);
    }

    @Override
    public Optional<Issue> get(String issueKey) {
        String sql = "SELECT issueKey, projectKey, type, summary, description, priority, assignee, reporter, state FROM Issue where issueKey = ?";
        Issue issue = null;

        try{
            issue = jdbcTemplate.queryForObject(sql, new Object[]{issueKey}, rowMapper);
        } catch (DataAccessException ex) {
            log.error("Issue not found for key " + issueKey);
        }
        return Optional.ofNullable(issue);
    }
}
