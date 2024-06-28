package com.school.studentms.SchoolStms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SchoolStmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolStmsApplication.class, args);
	}

}
