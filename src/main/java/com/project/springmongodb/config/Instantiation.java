package com.project.springmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.project.springmongodb.domain.Post;
import com.project.springmongodb.domain.User;
import com.project.springmongodb.dto.AuthorDTO;
import com.project.springmongodb.dto.CommentDTO;
import com.project.springmongodb.repository.PostRepository;
import com.project.springmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User user1 = new User(null, "Joseph Isaiah", "josisa@yahoo.com");
		User user2 = new User(null, "Ana Silva", "anasilva@google.com");
		User user3 = new User(null, "Joe Doe", "joedoe@yahoo.com");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
		Post post1 = new Post(null, sdf.parse("21/03/2025"), "Let's go on the trip", "See ya!", new AuthorDTO(user1));
		Post post2 = new Post(null, sdf.parse("23/03/2025"), "Good Morning", "Great Place!", new AuthorDTO(user1));
		
		CommentDTO cmt1 = new CommentDTO("Have a nice trip!", sdf.parse("22/03/2025"), new AuthorDTO(user2));
		CommentDTO cmt2 = new CommentDTO("Enjoy!", sdf.parse("22/03/2025"), new AuthorDTO(user3));
		CommentDTO cmt3 = new CommentDTO("Thank you", sdf.parse("22/03/2025"), new AuthorDTO(user1));
		CommentDTO cmt4 = new CommentDTO("Amazing!", sdf.parse("23/03/2025"), new AuthorDTO(user2));
		
		post1.getComments().addAll(Arrays.asList(cmt1, cmt2, cmt3));
		post2.getComments().addAll(Arrays.asList(cmt4));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		user1.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(user1);
	}

}
