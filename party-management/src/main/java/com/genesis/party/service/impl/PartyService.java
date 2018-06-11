package com.genesis.party.service.impl;

import org.springframework.stereotype.Service;

import com.genesis.common.service.impl.GenericServiceImpl;
import com.genesis.party.dao.PartyRepository;
import com.genesis.party.domain.Party;
import com.genesis.party.service.IPartyService;

/**
 * 
 * @author PalMurugan C
 *
 */

@Service
public class PartyService extends GenericServiceImpl<Party, Long> implements IPartyService {

	public PartyService(PartyRepository partyRepository) {
		super(partyRepository);
	}
}
