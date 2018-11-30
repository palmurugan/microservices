package com.genesis.party.service;

import com.genesis.common.service.IGenericService;
import com.genesis.party.domain.User;

public interface IUserService extends IGenericService<User, Long> {

	User createUser(User user);
}
