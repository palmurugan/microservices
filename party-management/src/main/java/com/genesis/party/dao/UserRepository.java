package com.genesis.party.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.genesis.party.domain.User;

/**
 * 
 * @author palmuruganc
 *
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
