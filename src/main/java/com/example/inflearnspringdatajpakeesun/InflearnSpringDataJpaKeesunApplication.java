package com.example.inflearnspringdatajpakeesun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

@SpringBootApplication
@Import(KeesunRegister.class)
@EnableJpaRepositories(
		queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND,
		repositoryImplementationPostfix = "Impl")
public class InflearnSpringDataJpaKeesunApplication {

	public static void main(String[] args) {
		SpringApplication.run(InflearnSpringDataJpaKeesunApplication.class, args);
	}

}
