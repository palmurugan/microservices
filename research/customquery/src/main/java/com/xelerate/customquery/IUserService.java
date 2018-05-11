package com.xelerate.customquery;

import com.xelerate.customquery.domain.User;

public interface IUserService {

	User createUser(User user);
	
	void deleteUser();
}
