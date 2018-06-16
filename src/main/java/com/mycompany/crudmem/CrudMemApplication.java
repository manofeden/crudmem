package com.mycompany.crudmem;

import static com.mycompany.crudmem.Astat.dataList;

import java.util.concurrent.CopyOnWriteArrayList;

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

		dataList = new CopyOnWriteArrayList<>();
		System.out.println("CREATE List clients ...");
	}
}
