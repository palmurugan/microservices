package com.genesis.users.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> testService() {
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

}
