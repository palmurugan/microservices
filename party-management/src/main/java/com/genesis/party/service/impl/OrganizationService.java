package com.genesis.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genesis.common.service.impl.GenericServiceImpl;
import com.genesis.party.dao.OrganizationRepository;
import com.genesis.party.domain.Organization;
import com.genesis.party.domain.Party;
import com.genesis.party.service.IOrganizationService;
import com.genesis.party.service.IPartyService;
import com.genesis.party.service.IPartyTypeService;

/**
 * 
 * @author PalMurugan C
 *
 */
@Service
public class OrganizationService extends GenericServiceImpl<Organization, Long> implements IOrganizationService {

	@Autowired
	private IPartyTypeService partyTypeService;

	@Autowired
	private IPartyService partyService;

	@Autowired
	private OrganizationRepository organizationRepository;

	public OrganizationService(OrganizationRepository repository) {
		super(repository);
	}

	@Override
	public Organization saveOrganization(Organization organization) {
		Party party = new Party(partyTypeService.get(1L).get());
		party = partyService.saveOrUpdate(party);
		organization.setPartyId(party.getPartyId());
		return organizationRepository.save(organization);
	}

}
