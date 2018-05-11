package com.xelerate.customquery;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.xelerate.customquery.domain.User;
import com.xelerate.customquery.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserRepository {
	
	@Autowired
	private UserRepository userRepository;

	//@Before
	public void testCreateUser() {
		userRepository.save(getTestData());
	}
	
	//@After
	public void deleteAllUser() {
		userRepository.deleteAll();
	}
	
	@Test
	public void testUserRecord() {
		Optional<User> user = userRepository.findById(1);
		assertEquals(user.get().getFirstName(), "pal");
	}
	
	@Test
	public void testGetUser() {
		Optional<User> user = userRepository.getUserByName("pal");
		assertEquals(user.get().getFirstName(), "pal");
		assertEquals(user.get().getLastName(), "murugan");
	}
	
	@Test
	public void testGetFirstName() {
		Optional<User> user = userRepository.getFirstNameByName("pal");
		assertEquals(user.get().getFirstName(), "pal");
		assertEquals(user.get().getLastName(), null);
	}
	
	@Test
	public void testGetAllUser() {
		List<User> userList = userRepository.getUserByAge(1, new Sort(Sort.Direction.DESC, "age", "firstName"));
		for(User user : userList) {
			System.out.println(user.getFirstName());
		}
	}
	
	@Test
	public void testGetUserByfNameAndlName() {
		Optional<User> user = userRepository.getUserByFirstNameAndLastName("pal", "murugan");
		assertEquals(user.get().getFirstName(), "pal");
		assertEquals(user.get().getLastName(), "murugan");
	}
	
	@Test
	public void testGetUserByCompareAge() {
		List<User> user = userRepository.getUserByCompareAge();
		Assert.assertNotNull(user);
	}
	
	private User getTestData() {
		return new User(1, "pal", "murugan", 3, 10, new Date(), new Date(), "admin", "admin");
	}

}
