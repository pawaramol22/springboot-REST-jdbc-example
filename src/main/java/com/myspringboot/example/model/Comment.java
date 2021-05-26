package com.myspringboot.example.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.juli.logging.Log;

import java.sql.Timestamp;

public class Comment {

    @JsonIgnore
    private Long id;
    @JsonAlias("key")
    private String issueKey;
    private String text;
    private String author;
    private Timestamp created;

    public Comment() {
    }

    public Comment(String issueKey, String text, String author, Timestamp created) {
        this.issueKey = issueKey;
        this.text = text;
        this.author = author;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssueKey() {
        return issueKey;
    }

    public void setIssueKey(String issueKey) {
        this.issueKey = issueKey;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comment{");
        sb.append("issueKey='").append(issueKey).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", created=").append(created);
        sb.append('}');
        return sb.toString();
    }
}
