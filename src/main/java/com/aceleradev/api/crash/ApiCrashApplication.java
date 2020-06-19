package com.aceleradev.api.crash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.aceleradev.api.crash" })
@SpringBootApplication
public class ApiCrashApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApiCrashApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiCrashApplication.class, args);
	}

}
