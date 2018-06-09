package com.genesis.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genesis.common.service.impl.GenericServiceImpl;
import com.genesis.party.dao.PartyRelationshipTypeRepository;
import com.genesis.party.domain.PartyRelationshipType;
import com.genesis.party.service.IPartyRelationshipTypeService;

/**
 * 
 * @author PalMurugan C
 *
 */
@Service
public class PartyRelationshipTypeService extends GenericServiceImpl<PartyRelationshipType, Long>
		implements IPartyRelationshipTypeService {

	@Autowired
	private PartyRelationshipTypeRepository partyRelationshipTypeRepository;

	public PartyRelationshipTypeService(PartyRelationshipTypeRepository partyRelationshipTypeRepository) {
		super(partyRelationshipTypeRepository);
	}

	@Override
	public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
		return partyRelationshipTypeRepository.existsByName(value.toString());
	}

}
