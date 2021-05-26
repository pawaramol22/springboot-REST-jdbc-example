package com.myspringboot.example.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Issue {

    @JsonIgnore
    private Long id;
    @JsonProperty("key")
    private String issueKey;
    private String projectKey;
    private String summary;
    private String description;
    private String issueType;
    private String priority;
    private String state;
    private String reporter;
    private String assignee;

    public Issue() {
    }

    public Issue(String issueKey, String projectKey, String summary, String description, String issueType, String priority, String state, String reporter, String assignee) {
        this.issueKey = issueKey;
        this.projectKey = projectKey;
        this.summary = summary;
        this.description = description;
        this.issueType = issueType;
        this.priority = priority;
        this.state = state;
        this.reporter = reporter;
        this.assignee = assignee;
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

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Issue{");
        sb.append("issueKey='").append(issueKey).append('\'');
        sb.append(", projectKey='").append(projectKey).append('\'');
        sb.append(", summary='").append(summary).append('\'');
        sb.append(", issueType='").append(issueType).append('\'');
        sb.append(", priority='").append(priority).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", reporter='").append(reporter).append('\'');
        sb.append(", assignee='").append(assignee).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
