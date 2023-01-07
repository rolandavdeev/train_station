package jwtrestapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtAppDemoApplication {

	public static final String ALLOWED_HOST = "http://vm4003456.25ssd.had.wf:3000/";

	public static void main(String[] args) {
		SpringApplication.run(JwtAppDemoApplication.class, args);
	}

}
