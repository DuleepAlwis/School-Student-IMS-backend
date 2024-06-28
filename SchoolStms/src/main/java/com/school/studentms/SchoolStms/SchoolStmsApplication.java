package com.school.studentms.SchoolStms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan(basePackages= {"com.school.studentms.entity"})
@ComponentScan(basePackages= {"com.school.studentms.config",
		"com.school.studentms.controller","com.school.studentms.repository",
		"com.school.studentms.service","com.school.studentms.utility"})
@EnableJpaRepositories(basePackages= {"com.school.studentms.repository"})
@SpringBootApplication
@EnableTransactionManagement
public class SchoolStmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolStmsApplication.class, args);
	}

}
