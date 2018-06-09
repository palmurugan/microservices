package com.genesis.party.service.impl;

import org.springframework.stereotype.Service;

import com.genesis.common.service.impl.GenericServiceImpl;
import com.genesis.party.dao.PartyRelationshipRepository;
import com.genesis.party.domain.PartyRelationship;
import com.genesis.party.service.IPartyRelationshipService;

/**
 * 
 * @author PalMurugan C
 *
 */
@Service
public class PartyRelationshipService extends GenericServiceImpl<PartyRelationship, Long>
		implements IPartyRelationshipService {

	public PartyRelationshipService(PartyRelationshipRepository partyRelationshipRepository) {
		super(partyRelationshipRepository);
    }
}
