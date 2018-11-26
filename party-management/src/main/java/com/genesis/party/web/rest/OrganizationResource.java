package com.genesis.party.web.rest;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.party.domain.Organization;
import com.genesis.party.service.IOrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationResource {

	private IOrganizationService organizationService;

	@Inject
	public OrganizationResource(IOrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Organization create(@Valid @RequestBody Organization organization) {
		return organizationService.saveOrganization(organization);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Page<Organization> getAll(Pageable pageable) {
		return organizationService.getAll(pageable);
	}

}
