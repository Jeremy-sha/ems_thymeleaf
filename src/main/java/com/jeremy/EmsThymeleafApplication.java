package com.jeremy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.jeremy.dao")
@SpringBootApplication
public class EmsThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsThymeleafApplication.class, args);
	}

}
