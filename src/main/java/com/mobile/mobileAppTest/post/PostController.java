package com.mobile.mobileAppTest.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.mobileAppTest.appUser.AppUser;
import com.mobile.mobileAppTest.appUser.AppUserRepository;

@RestController
@RequestMapping("/users/post")
public class PostController {
	@Autowired
	PostService service;
	@Autowired
	AppUserRepository apprepo;
	
	
	
	@GetMapping("/getAllPost")
	public List<Post> getAllPost(){
		return service.getAllPost();
	}
	
	@PostMapping("{id}")
	  public Post createPost(@PathVariable("id")Long id,@RequestBody Post postRequest) throws Exception {
		AppUser user = apprepo.findById(id).orElseThrow(() ->
        new Exception("user not found "));
		Post post = new Post(postRequest.getPostUrl(),postRequest.getCreatedDate() , user);
		return service.save(post);
	 
	  }

}