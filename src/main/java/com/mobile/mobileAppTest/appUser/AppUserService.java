package com.mobile.mobileAppTest.appUser;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mobile.mobileAppTest.post.Post;
import com.mobile.mobileAppTest.registration.token.ConfirmationToken;
import com.mobile.mobileAppTest.registration.token.ConfirmationTokenService;
@Service
public class AppUserService implements UserDetailsService{
	@Autowired
     AppUserRepository repo ;
      @Autowired
	 private BCryptPasswordEncoder  bCryptPasswordEncoder;
      @Autowired
      private ConfirmationTokenService serviceToken;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return repo.findByEmail(email).orElseThrow(() ->
        new UsernameNotFoundException("user not found "));
}
	
	public String SignUp(AppUser user) throws Exception{
		boolean exist = repo
                .findByEmail(user.getEmail())
                .isPresent();
      if(exist) {
    	  throw new Exception("email is taking");
      }
      String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
      user.setPassword(encodedPassword);
      repo.save(user);
      
  		
      
      String Token = UUID.randomUUID().toString();
      
      ConfirmationToken token = new ConfirmationToken(
    		  Token,
    		  LocalDateTime.now(),
    		  LocalDateTime.now().plusMinutes(15),
    		  user
    		  );
    		  serviceToken.saveConfirmation(token);
		return "Your token number " + Token;
		
	}

	  public int enableAppUser(String email) { 
		  return repo.enableAppUser(email); 
	  }
	

}
