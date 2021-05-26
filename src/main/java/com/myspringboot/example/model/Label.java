package com.myspringboot.example.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;

public class Label {

    @JsonIgnore
    private Long id;
    @JsonAlias("key")
    private String issueKey;
    private String name;

    public Label() {
    }

    public Label(String issueKey, String name) {
        this.issueKey = issueKey;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Label{");
        sb.append("issueKey='").append(issueKey).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
