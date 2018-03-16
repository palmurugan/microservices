package com.genesis.party.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.genesis.party.domain.PartyRelationshipType;

@Repository
public interface PartyRelationshipTypeRepository extends PagingAndSortingRepository<PartyRelationshipType, Long> {

}
