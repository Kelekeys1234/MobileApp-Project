package com.mobile.mobileAppTest.registration.token;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenService {
	@Autowired
     private ConfirmationRepository repo;
		
	
	public void saveConfirmation(ConfirmationToken token) {
		repo.save(token);
	}
	   public Optional<ConfirmationToken> getToken(String token) {
	        return repo.findByToken(token);
	    }

	    public int setConfirmedAt(String token) {
	        return repo.updateConfirmedAt(
	                token, LocalDateTime.now());
	    }
	
}
