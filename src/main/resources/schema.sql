CREATE TABLE Issue (
    id long identity NOT NULL,
    issueKey varchar(32) NOT NULL,
    projectKey varchar(32) NOT NULL,
    summary varchar(256) NOT NULL,
    description varchar(512),
    type varchar(128) NOT NULL,
    priority varchar(32),
    state varchar(32),
    reporter varchar(32),
    assignee varchar(32),
    CONSTRAINT pk_issue_id PRIMARY KEY (id),
    UNIQUE KEY issue_issue_key_unique (issueKey)
);

CREATE TABLE Label (
    id long identity NOT NULL,
    issueKey varchar(32) NOT NULL,
    name varchar(256) NOT NULL,
    CONSTRAINT pk_label_id PRIMARY KEY (id),
    foreign key (issueKey) references Issue(issueKey)
);

CREATE TABLE Component (
    id long identity NOT NULL,
    issueKey varchar(32) NOT NULL,
    name varchar(256) NOT NULL,
    CONSTRAINT pk_component_id PRIMARY KEY (id),
    foreign key (issueKey) references Issue(issueKey)
);

CREATE TABLE Comment (
    id long identity NOT NULL,
    issueKey varchar(32) NOT NULL,
    text varchar(4000) NOT NULL,
    author varchar(21) NOT NULL,
    created timestamp NOT NULL,
    CONSTRAINT pk_comment_id PRIMARY KEY (id),
    foreign key (issueKey) references Issue(issueKey)
);