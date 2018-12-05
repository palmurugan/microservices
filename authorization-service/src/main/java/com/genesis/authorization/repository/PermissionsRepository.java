package com.genesis.authorization.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.genesis.authorization.domain.Permissions;

/**
 * 
 * @author PalMurugan C
 *
 */
 
@Repository
public interface PermissionsRepository extends PagingAndSortingRepository<Permissions, Long> {

}
