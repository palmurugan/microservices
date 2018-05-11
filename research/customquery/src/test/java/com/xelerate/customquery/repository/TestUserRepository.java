package com.xelerate.customquery.repository;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xelerate.customquery.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestUserRepository {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testCreateUser() {
		userRepository.save(getTestData());
	}

	private User getTestData() {
		return new User(2, "pal1", "murugan1", 3, 10, new Date(), new Date(), "admin", "admin");
	}

}
