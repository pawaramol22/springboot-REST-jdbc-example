package com.myspringboot.example;

import com.myspringboot.example.dao.JiraDAO;
import com.myspringboot.example.model.Issue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@SpringBootApplication
public class MySpringBootApplication {

	private static JiraDAO dao;

	public MySpringBootApplication(JiraDAO<Issue> dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApplication.class, args);

		Pageable pageable = PageRequest.of(0, 5);
		Page<Issue> page = dao.list(pageable);
		page.getContent().forEach(System.out::println);

		System.out.println(dao.get("JIRA-1"));
		System.out.println(dao.get("JIRA-100"));
	}

}
