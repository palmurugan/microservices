package com.genesis.party.service.impl;

import static com.genesis.party.util.ApplicationConstants.ACTIVE;

import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.genesis.party.dao.PartyTypeRepository;
import com.genesis.party.domain.PartyType;
import com.genesis.party.service.IPartyTypeService;

/**
 * 
 * @author PalMurugan C
 *
 */
@Service
@Transactional
public class PartyTypeService implements IPartyTypeService {

	private PartyTypeRepository partyTypeRepository;

	@Inject
	public PartyTypeService(PartyTypeRepository partyTypeRepository) {
		this.partyTypeRepository = partyTypeRepository;
	}

	@Override
	public PartyType saveOrUpdatePartyType(PartyType partyType) {
		partyType.setStatus(ACTIVE);
		return partyTypeRepository.save(partyType);
	}

	@Override
	public Page<PartyType> getAllPartyTypeList(Pageable pageable) {
		return partyTypeRepository.findAll(pageable);
	}

	@Override
	public Optional<PartyType> getPartyType(Long partyTypeId) {
		return partyTypeRepository.findById(partyTypeId);
	}

	@Override
	public void deletePartyType(Long partyTypeId) {
		partyTypeRepository.deleteById(partyTypeId);
	}

	@Override
	public boolean fieldValueExists(Object value, String fieldName) {
		return partyTypeRepository.existsByName(value.toString());
	}
}
