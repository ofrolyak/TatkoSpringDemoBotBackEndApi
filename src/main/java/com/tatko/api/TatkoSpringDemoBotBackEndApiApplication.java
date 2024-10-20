package com.tatko.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories
public class TatkoSpringDemoBotBackEndApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TatkoSpringDemoBotBackEndApiApplication.class, args);
	}

}
