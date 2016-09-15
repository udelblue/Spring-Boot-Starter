package com.example.controllers.security;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.models.security.User;
import com.example.repository.security.UserRepository;

@Controller
@RequestMapping(value = "/Account")
public class UserProfileController {

	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/Profile", method = RequestMethod.GET)
    @ResponseBody
    public String myProfile(Principal principal) {
		User currentUser = userRepository.findByUsername(principal.getName());
		if (currentUser == null ) {
			return "";
		}
		
		
		
        return"" ;
    }
	
	
}
