package com.example.util.audit;

import java.util.Date;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;



public class RevRevisionListener implements RevisionListener {


    @Override
    public void newRevision(Object revisionEntity) {

    	Revinfo revEntity = (Revinfo) revisionEntity;
        revEntity.setUsername("Unknown Username");
        revEntity.setDate_of_execution(new Date());
    	revEntity.setIp_address("Unknown Address");
    	
    	try {
    		
    		Authentication details = SecurityContextHolder.getContext().getAuthentication();
    		 revEntity.setUsername(details.getName());
		} catch (Exception e) {
			
		}
    	
    	
    	try {
    		 WebAuthenticationDetails details = (WebAuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
        	 String ip = details.getRemoteAddress();
        	 revEntity.setIp_address(ip);
        	 
		} catch (Exception e) {
			
		}
    	 

    	
    	
    	
    }
}
