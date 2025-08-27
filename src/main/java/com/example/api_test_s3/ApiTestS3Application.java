package com.example.api_test_s3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ApiTestS3Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiTestS3Application.class, args);
	}

}
