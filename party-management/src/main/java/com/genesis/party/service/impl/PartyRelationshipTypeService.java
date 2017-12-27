package com.genesis.party.service.impl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.genesis.party.dao.PartyRelationshipTypeRepository;
import com.genesis.party.domain.PartyRelationshipType;
import com.genesis.party.service.IPartyRelationshipTypeService;

/**
 * 
 * @author PalMurugan C
 *
 */
@Service
public class PartyRelationshipTypeService implements IPartyRelationshipTypeService {

    private PartyRelationshipTypeRepository partyRelationshipTypeRepository;

    @Inject
    public PartyRelationshipTypeService(PartyRelationshipTypeRepository partyRelationshipTypeRepository) {
        this.partyRelationshipTypeRepository = partyRelationshipTypeRepository;
    }

    @Override
    public PartyRelationshipType saveOrUpdate(PartyRelationshipType entity) {
        return partyRelationshipTypeRepository.save(entity);
    }

    @Override
    public Page<PartyRelationshipType> getAll(Pageable pageable) {
        return partyRelationshipTypeRepository.findAll(pageable);
    }

    @Override
    public PartyRelationshipType get(Long id) {
        return partyRelationshipTypeRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        partyRelationshipTypeRepository.delete(id);
    }
}
