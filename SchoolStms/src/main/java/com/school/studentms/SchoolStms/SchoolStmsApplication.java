package com.school.studentms.SchoolStms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages= {"com.school.studentms.config",
		"com.school.studentms.controller","com.school.studentms.dao.DaoImpl",
		"com.school.studentms.service.ServiceImpl","com.school.studentms.utility"})
@SpringBootApplication
@EnableTransactionManagement
public class SchoolStmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolStmsApplication.class, args);
	}

}
