package com.notifyLogist.demoApp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DemoApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoApp1Application.class, args);
	}

}
