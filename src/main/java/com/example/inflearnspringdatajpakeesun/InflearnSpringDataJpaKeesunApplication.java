package com.example.inflearnspringdatajpakeesun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(KeesunRegister.class)
public class InflearnSpringDataJpaKeesunApplication {

	public static void main(String[] args) {
		SpringApplication.run(InflearnSpringDataJpaKeesunApplication.class, args);
	}

}
