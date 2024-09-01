package dev.pichborith.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuthApp {

	public static void main(String[] args) {
		SpringApplication.run(AuthApp.class, args);
	}

}
