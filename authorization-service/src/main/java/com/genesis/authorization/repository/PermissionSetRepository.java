package com.genesis.authorization.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.genesis.authorization.domain.PermissionSet;

/**
 * 
 * @author PalMurugan C
 *
 */
 
@Repository
public interface PermissionSetRepository extends PagingAndSortingRepository<PermissionSet, Long> {

}
