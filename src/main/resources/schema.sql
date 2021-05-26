CREATE TABLE Issue (
    id integer identity NOT NULL,
    issueKey varchar(32) NOT NULL,
    summary varchar(256) NOT NULL,
    description varchar(512),
    type varchar(128) NOT NULL,
    priority varchar(32),
    state varchar(32),
    reporter varchar(32),
    assignee varchar(32),
    CONSTRAINT pk_issue_id PRIMARY KEY (id)
);