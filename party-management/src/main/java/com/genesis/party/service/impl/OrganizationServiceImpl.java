package com.genesis.party.service.impl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.genesis.party.dao.OrganizationRepository;
import com.genesis.party.domain.Organization;
import com.genesis.party.domain.Party;
import com.genesis.party.domain.PartyType;
import com.genesis.party.service.IOrganizationService;
import com.genesis.party.service.IPartyTypeService;

/**
 * 
 * @author PalMurugan C
 *
 */
@Service
public class OrganizationServiceImpl implements IOrganizationService {

    private OrganizationRepository organizationRepository;

    private IPartyTypeService partyTypeService;

    @Inject
    public OrganizationServiceImpl(OrganizationRepository organizationRepository, IPartyTypeService partyTypeService) {
        this.organizationRepository = organizationRepository;
        this.partyTypeService = partyTypeService;
    }

    @Override
    public Organization saveOrUpdate(Organization organization) {
        PartyType partyType = partyTypeService.getPartyType(1L);
        Party party = new Party(partyType);
        organization.setParty(party);
        return organizationRepository.save(organization);
    }

    @Override
    public Page<Organization> getAll(Pageable pageable) {
        return organizationRepository.findAll(pageable);
    }

    @Override
    public Organization get(Long id) {
        return organizationRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        organizationRepository.delete(id);
    }
}
