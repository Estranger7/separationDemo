package com.example.demo.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.example.demo.db.dao.**")
public class DbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbApplication.class, args);
	}

}
