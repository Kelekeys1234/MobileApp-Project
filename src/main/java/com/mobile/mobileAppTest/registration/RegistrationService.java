package com.mobile.mobileAppTest.registration;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobile.mobileAppTest.appUser.AppUser;
import com.mobile.mobileAppTest.appUser.AppUserRole;
import com.mobile.mobileAppTest.appUser.AppUserService;
import com.mobile.mobileAppTest.registration.token.ConfirmationToken;
import com.mobile.mobileAppTest.registration.token.ConfirmationTokenService;

@Service
public class RegistrationService {
	@Autowired
	AppUserService appservice;
	@Autowired
	RegistrationEmailValidator emailValid ;
	@Autowired
	ConfirmationTokenService service;
	@Autowired
	AppUserService appUserService;
	
  public String register(RegistrationRequest request) throws Exception {
	  Boolean isvalid= emailValid.test(request.getEmail());
      if(!isvalid) {
    	  throw new Exception("email not valid");
      };
	return appservice.SignUp(new AppUser(
			request.getUserName(),
			request.getMobile(),
			request.getEmail(),
			request.getPassword(),
			AppUserRole.USER
			
			));
	
  }
  @Transactional
  public String confirmToken(String token) {
      ConfirmationToken confirmationToken = service
              .getToken(token)
              .orElseThrow(() ->
                      new IllegalStateException("token not found"));

      if (confirmationToken.getConfirmedAt() != null) {
          throw new IllegalStateException("email already confirmed");
      }

      LocalDateTime expiredAt = confirmationToken.getExpiredAt();

      if (expiredAt.isBefore(LocalDateTime.now())) {
          throw new IllegalStateException("token expired");
      }

    service.setConfirmedAt(token);
      appUserService.enableAppUser(
              confirmationToken.getAppuser().getEmail());
      return "confirmed";
  }
}
