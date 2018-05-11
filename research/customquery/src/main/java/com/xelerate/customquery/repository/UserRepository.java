package com.xelerate.customquery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.xelerate.customquery.domain.User;

@Repository("userRepository")
public interface UserRepository extends MongoRepository<User, Integer> {

	@Query("{ 'firstName' : ?0 }") // Fields: { 'age' }, Sort: {}
	public Optional<User> getUserByName(String firstName);
	
	@Query(value="{ 'firstName' : ?0 }", fields="{firstName : 1, _id : 0}")
	public Optional<User> getFirstNameByName(String firstName); // {},{"firstName":1}
	
	@Query("{ age: { $gt: 1 } }")
	public List<User> getUserByAge(Integer age, Sort direction);
	
	@Query("{ 'age' : { $gt: ?0, $lt: ?1 } }")
	public List<User> getUserByAge(Integer minAge, Integer maxAge);

	@Query("{ 'firstName' : ?0, 'lastName': ?1 }")
	public Optional<User> getUserByFirstNameAndLastName(String firstName, String lastName);

	@Query("{'$where':'this.age < this.maxAge'}")
	public List<User> getUserByCompareAge();
	
	@Query("{$and : [{'$where':'this.age < this.maxAge'},{'$where':'this.age < this.maxAge'}]}")
	public List<User> getUserByMultipleCompare();
}
