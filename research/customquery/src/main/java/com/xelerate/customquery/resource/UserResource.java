package com.xelerate.customquery.resource;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xelerate.customquery.domain.User;
import com.xelerate.customquery.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<User> createUser() {
		return new ResponseEntity<>(userRepository.save(getTestData()),HttpStatus.CREATED);
	}
	
	private User getTestData() {
		return new User(1, "pal", "murugan", 2, 12, new Date(), new Date(), "admin", "admin");
	}
}
