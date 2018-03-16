package com.genesis.party.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.genesis.party.domain.Party;

/**
 * 
 * @author PalMurugan C
 *
 */

@Repository
public interface PartyRepository extends PagingAndSortingRepository<Party, Long> {

}
