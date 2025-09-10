package com.project.springmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.springmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
