package com.genesis.party.web.rest;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.party.domain.User;
import com.genesis.party.service.IUserService;

/**
 * 
 * @author palmuruganc
 *
 */
@RestController("userManageResource")
@RequestMapping("/users")
public class UserResource {

	private IUserService userService;

	@Inject
	public UserResource(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return userService.createUser(user);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Page<User> getAll(Pageable pageable) {
		return userService.getAll(pageable);
	}
}
