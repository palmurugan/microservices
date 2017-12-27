package com.genesis.party.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.genesis.party.domain.PartyRelationship;

/**
 * 
 * @author PalMurugan
 *
 */
@Repository
public interface PartyRelationshipRepository extends PagingAndSortingRepository<PartyRelationship, Long> {

}
