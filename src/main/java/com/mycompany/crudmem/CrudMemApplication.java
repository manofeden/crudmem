package com.mycompany.crudmem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class CrudMemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudMemApplication.class, args);
		System.out.println("*********************************** CrudMem STARTED SUCCESSFULLY  ***********************************");
	}
}
