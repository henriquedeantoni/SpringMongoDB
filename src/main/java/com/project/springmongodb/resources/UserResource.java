package com.project.springmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springmongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity< List<User>> findAll(){
		User userTest1 = new User("1", "Joe Doe","joedoe@gmail.com");
		User userTest2 = new User("2", "Joe Doe2","joedoe@yahoo.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(userTest1, userTest2));
		
		return ResponseEntity.ok().body(list);
	}
}
