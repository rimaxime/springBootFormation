package com.mriviere.firstmicroservice;

import com.mriviere.firstmicroservice.rest.MyAppRessource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MyappApplication /*WAR PACKAGING: extends SpringBootServletInitializer*/{

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

	/* WAR PACKAGING
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyappApplication.class);
	}
	*/
}
