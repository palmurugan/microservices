package com.genesis.party.service.impl;

import java.util.Objects;

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
    public Party saveOrUpdate(Party entity) {
        if (Objects.isNull(entity.getPartyType())) {
            throw new PartyManagementException("Please Provide Party Type");
        }
        PartyType partyType = partyTypeService.getPartyType(entity.getPartyType().getPartyTypeId());
        entity.setPartyType(partyType);
        return partyRepository.save(entity);
    }

    @Override
    public Page<Party> getAll(Pageable pageable) {
        return partyRepository.findAll(pageable);
    }

    @Override
    public Party get(Long id) {
        return partyRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        partyRepository.delete(id);
    }

}
