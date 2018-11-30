package com.genesis.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genesis.common.service.impl.GenericServiceImpl;
import com.genesis.party.dao.UserRepository;
import com.genesis.party.domain.User;
import com.genesis.party.service.IPartyTypeService;
import com.genesis.party.service.IUserService;
import com.genesis.party.util.ApplicationConstants;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IPartyTypeService partyTypeService;

	public UserServiceImpl(UserRepository repository) {
		super(repository);
	}

	@Override
	public User createUser(User user) {
		partyTypeService.findByName(ApplicationConstants.USER).map(partyType -> {
			user.setPartyId(partyType.getPartyTypeId());
			return user;
		});
		return userRepository.save(user);
	}
}
