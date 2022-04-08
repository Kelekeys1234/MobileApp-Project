package com.mobile.mobileAppTest.registration;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;
@Service
public class RegistrationEmailValidator implements Predicate<String>{

	@Override
	public boolean test(String t) {
		// TODO Auto-generated method stub
		return true;
	}

}
