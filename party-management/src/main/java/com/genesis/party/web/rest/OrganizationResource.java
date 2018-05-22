package com.genesis.party.web.rest;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Organization> createOrganization(@Valid @RequestBody Organization organization) {
        return new ResponseEntity<Organization>(organizationService.saveOrUpdate(organization), HttpStatus.CREATED);
    }
}
