package com.mobile.mobileAppTest.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	@Autowired
   private PostRepository repository;
	
   public Post save(Post post) {
	   return repository.save(post);
   }
  public List<Post> getAllPost(){
	  return repository.findAll();
  }
}
