package com.example.inflearnspringdatajpakeesun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

@SpringBootApplication
@EnableJpaRepositories(
		queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND,
		repositoryImplementationPostfix = "Impl")
@EnableJpaAuditing(auditorAwareRef = "accountAuditAware")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
