package com.financial.finApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import com.financial.finApp.entity.User;
import com.financial.finApp.dao.UserDAO;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class FinAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDAO userDAO) {
		return runner -> {
			createUser(userDAO);
		};
	}

	private void createUser(UserDAO userDAO) {
		System.out.println("Creating new user");
		User tempUser = new User("newuser", "newpassword");

		userDAO.save(tempUser);
	}

}
