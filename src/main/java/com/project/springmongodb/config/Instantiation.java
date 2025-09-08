package com.project.springmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.project.springmongodb.domain.User;
import com.project.springmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		
		User user1 = new User(null, "Joseph Isaiah", "josisa@yahoo.com");
		User user2 = new User(null, "Ana Silva", "anasilva@google.com");
		User user3 = new User(null, "Joe Doe", "joedoe@yahoo.com");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
	}

}
