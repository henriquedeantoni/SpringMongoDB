package com.project.springmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.springmongodb.domain.Post;
import com.project.springmongodb.resources.util.URL;
import com.project.springmongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	

	@GetMapping(value="/{id}")
	public ResponseEntity< Post> findById(@PathVariable String id){
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}

	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="title", defaultValue="") String title){
		title = URL.decodeParam(title);
		List<Post> list = service.findByTitle(title);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/titlesparams")
	public ResponseEntity<List<Post>> findByTitleWithParams(@RequestParam(value="title", defaultValue="") String title){
		title = URL.decodeParam(title);
		List<Post> list = service.findByTitle(title);
		return ResponseEntity.ok().body(list);
	}
}
