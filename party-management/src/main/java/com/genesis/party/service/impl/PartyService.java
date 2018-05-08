package com.genesis.party.service.impl;

import java.util.Objects;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.genesis.party.dao.PartyRepository;
import com.genesis.party.domain.Party;
import com.genesis.party.domain.PartyType;
import com.genesis.party.service.IPartyService;
import com.genesis.party.service.IPartyTypeService;
import com.genesis.party.web.exception.PartyManagementException;
import com.genesis.party.web.exception.PartyTypeNotFoundException;

/**
 * 
 * @author PalMurugan C
 *
 */

@Service
@Transactional
public class PartyService implements IPartyService {

	private PartyRepository partyRepository;

	private IPartyTypeService partyTypeService;

	@Inject
	public PartyService(PartyRepository partyRepository, IPartyTypeService partyTypeService) {
		this.partyRepository = partyRepository;
		this.partyTypeService = partyTypeService;
	}

	@Override
	public Party saveOrUpdate(Party party) {
		if (Objects.isNull(party.getPartyType())) {
			throw new PartyManagementException("Please Provide Party Type");
		}
		Optional<PartyType> partyType = partyTypeService.getPartyType(party.getPartyType().getPartyTypeId());
		if (!partyType.isPresent()) {
			throw new PartyTypeNotFoundException("Provided party type is not found");
		}
		party.setPartyType(partyType.get());
		return partyRepository.save(party);
	}

	@Override
	public Page<Party> getAll(Pageable pageable) {
		return partyRepository.findAll(pageable);
	}

	@Override
	public Optional<Party> get(Long id) {
		return partyRepository.findById(id);
	}

	@Override
	public void remove(Long id) {
		partyRepository.deleteById(id);
	}

}
