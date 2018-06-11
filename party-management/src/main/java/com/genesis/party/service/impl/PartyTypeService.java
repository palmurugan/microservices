package com.genesis.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genesis.common.service.impl.GenericServiceImpl;
import com.genesis.party.dao.PartyTypeRepository;
import com.genesis.party.domain.PartyType;
import com.genesis.party.service.IPartyTypeService;

/**
 * 
 * @author PalMurugan C
 *
 */
@Service
public class PartyTypeService extends GenericServiceImpl<PartyType, Long> implements IPartyTypeService {

	@Autowired
	private PartyTypeRepository partyTypeRepository;

	public PartyTypeService(PartyTypeRepository partyTypeRepository) {
		super(partyTypeRepository);
	}

	@Override
	public boolean fieldValueExists(Object value, String fieldName) {
		return partyTypeRepository.existsByName(value.toString());
	}
}
