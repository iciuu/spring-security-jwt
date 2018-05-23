package com.ng.howlongapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.ng.howlongapi.mapper")
@SpringBootApplication
public class HowlongApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HowlongApiApplication.class, args);
	}
}
