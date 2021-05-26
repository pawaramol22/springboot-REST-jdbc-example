insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('JIRA-1', 'JIRA', 'First Issue', 'First description', 'Task', 'P1', 'New', 'bruce', 'clark');
insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('JIRA-2', 'JIRA', 'Second Issue', 'Second description', 'Bug', 'P2', 'Open', 'clark', 'bruce');
insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('JIRA-3', 'JIRA', 'Third Issue', 'Third description', 'Story', 'P3', 'In Progress', 'bruce', 'harvey');
insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('JIRA-4', 'JIRA', 'Fourth Issue', 'Fourth description', 'Incident', 'P4', 'Done', 'bruce', 'clark');
insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('JIRA-5', 'JIRA', 'Fifth Issue', 'Fifth description', 'Task', 'P5', 'New', 'harvey', 'clark');
insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('JIRA-6', 'JIRA', 'Sixth Issue', 'Sixth description', 'Task', 'P1', 'Open', 'bruce', 'clark');
insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('JIRA-7', 'JIRA', 'Seventh Issue', 'Seventh description', 'Task', 'P2', 'In Progress', 'bruce', 'gordon');
insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('JIRA-8', 'JIRA', 'Eighth Issue', 'Eighth description', 'Task', 'P3', 'On Hold', 'bruce', 'celina');
insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('JIRA-9', 'JIRA', 'Ninth Issue', 'Ninth description', 'Task', 'P4', 'Done', 'celina', 'bruce');
insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('JIRA-10', 'JIRA', 'Tenth Issue', 'Tenth description', 'Task', 'P5', 'New', 'bruce', 'clark');
insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('CONF-1', 'CONF', 'First Confluence Issue', 'First Confluence description', 'Task', 'P1', 'New', 'bruce', 'clark');
insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('CONF-2', 'CONF', 'Second Confluence Issue', 'Second Confluence description', 'Bug', 'P2', 'In Progress', 'bruce', 'clark');
insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('CONF-3', 'CONF', 'Third Confluence Issue', 'Third Confluence description', 'Story', 'P3', 'Open', 'bruce', 'clark');
insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('CONF-4', 'CONF', 'Fourth Confluence Issue', 'Fourth Confluence description', 'Incident', 'P4', 'New', 'bruce', 'clark');
insert into issue(issueKey, projectKey, summary, description, type, priority, state, reporter, assignee) values ('CONF-5', 'CONF', 'Fifth Confluence Issue', 'Fifth Confluence description', 'Task', 'P5', 'Done', 'bruce', 'clark');

-- Add labels
insert into label(issueKey, name) values ('JIRA-1', 'Label-1');
insert into label(issueKey, name) values ('JIRA-2', 'Label-21');
insert into label(issueKey, name) values ('JIRA-2', 'Label-22');
insert into label(issueKey, name) values ('JIRA-3', 'Label-31');
insert into label(issueKey, name) values ('JIRA-3', 'Label-32');
-- Add Components
insert into component(issueKey, name) values ('JIRA-1', 'Component-1');
insert into component(issueKey, name) values ('JIRA-2', 'Component-2');
insert into component(issueKey, name) values ('JIRA-3', 'Component-3');
insert into component(issueKey, name) values ('JIRA-4', 'Component-4');
insert into component(issueKey, name) values ('JIRA-5', 'Component-5');
-- Add Comments
insert into comment(issueKey, text, author, created) values ('JIRA-1', 'First comment', 'bruce', CURRENT_TIMESTAMP());
insert into comment(issueKey, text, author, created) values ('JIRA-1', 'Second comment', 'celina', CURRENT_TIMESTAMP());
insert into comment(issueKey, text, author, created) values ('JIRA-2', 'First comment', 'clark', CURRENT_TIMESTAMP());
insert into comment(issueKey, text, author, created) values ('JIRA-3', 'First comment', 'celina', CURRENT_TIMESTAMP());
insert into comment(issueKey, text, author, created) values ('JIRA-4', 'First comment', 'harvey', CURRENT_TIMESTAMP());
