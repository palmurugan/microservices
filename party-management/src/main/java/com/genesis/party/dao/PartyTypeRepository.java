package com.genesis.party.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.genesis.party.domain.PartyType;

@Repository
public interface PartyTypeRepository extends PagingAndSortingRepository<PartyType, Long> {

}
