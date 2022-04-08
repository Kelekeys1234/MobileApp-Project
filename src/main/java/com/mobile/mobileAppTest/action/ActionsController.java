package com.mobile.mobileAppTest.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.mobileAppTest.appUser.AppUser;
import com.mobile.mobileAppTest.appUser.AppUserRepository;
import com.mobile.mobileAppTest.post.Post;
import com.mobile.mobileAppTest.post.PostRepository;

@RestController
@RequestMapping("/post/actions")
public class ActionsController {
	@Autowired
     PostRepository postrepository;
	@Autowired
	AppUserRepository userRepo;
	@Autowired
	ActionService actionService;
	
	
	
	@PostMapping("{appId}")
	private Actions createActions(@PathVariable("appId") Long appId,@RequestParam("postId") Long postId,@RequestBody Actions actions) throws Exception {
		
		//initialize the post by Id
	Post post =  postrepository.findById(postId).orElseThrow(()-> new Exception("Post is empty"));
		
		//initialize the user by Id
		AppUser user = userRepo.findById(appId).orElseThrow(()-> new Exception("userId not found"));;
		Actions action =new Actions(actions.getIsLike(), actions.getIsShared(), actions.getIsCommented() , post ,user);
		
		return actionService.save(action);
		
	}
	
	@GetMapping("/getAllActions")
	public List<Actions> getAllActions(){
		return actionService.getAllActions();
	}
}
