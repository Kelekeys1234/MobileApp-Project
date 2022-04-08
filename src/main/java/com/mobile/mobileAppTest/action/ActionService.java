package com.mobile.mobileAppTest.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService {
	@Autowired
	ActionRepository actionrepo;
	
	
   public Actions save(Actions action) {
	return actionrepo.save(action);
	   
   }
   public List<Actions> getAllActions(){
	   return actionrepo.findAll();
   }
}
