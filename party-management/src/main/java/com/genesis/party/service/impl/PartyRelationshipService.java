package com.genesis.party.service.impl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.genesis.party.dao.PartyRelationshipRepository;
import com.genesis.party.domain.Party;
import com.genesis.party.domain.PartyRelationship;
import com.genesis.party.domain.PartyRelationshipType;
import com.genesis.party.service.IPartyRelationshipService;
import com.genesis.party.service.IPartyRelationshipTypeService;
import com.genesis.party.service.IPartyService;

/**
 * 
 * @author PalMurugan C
 *
 */
@Service
public class PartyRelationshipService implements IPartyRelationshipService {

    private PartyRelationshipRepository partyRelationshipRepository;

    private IPartyService partyService;

    private IPartyRelationshipTypeService partyRelationshipTypeService;

    @Inject
    public PartyRelationshipService(PartyRelationshipRepository partyRelationshipRepository, IPartyService partyService,
            IPartyRelationshipTypeService partyRelationshipTypeService) {
        this.partyRelationshipRepository = partyRelationshipRepository;
        this.partyService = partyService;
        this.partyRelationshipTypeService = partyRelationshipTypeService;
    }

    @Override
    public PartyRelationship saveOrUpdate(PartyRelationship partyRelationship) {
        Party party1 = partyService.get(partyRelationship.getParty1().getPartyId());
        Party party2 = partyService.get(partyRelationship.getParty2().getPartyId());
        PartyRelationshipType partyRelationshipType =
                partyRelationshipTypeService.get(partyRelationship.getPartyRelationshipType().getPartyRelationshipTypeId());
        partyRelationship.setParty1(party1);
        partyRelationship.setParty2(party2);
        partyRelationship.setPartyRelationshipType(partyRelationshipType);
        return partyRelationshipRepository.save(partyRelationship);
    }

    @Override
    public Page<PartyRelationship> getAll(Pageable pageable) {
        return partyRelationshipRepository.findAll(pageable);
    }

    @Override
    public PartyRelationship get(Long id) {
        return partyRelationshipRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        partyRelationshipRepository.delete(id);
    }
}
