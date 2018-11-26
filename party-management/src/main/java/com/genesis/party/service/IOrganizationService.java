package com.genesis.party.service;

import com.genesis.common.service.IGenericService;
import com.genesis.party.domain.Organization;

public interface IOrganizationService extends IGenericService<Organization, Long> {

	Organization saveOrganization(Organization organization);
}
