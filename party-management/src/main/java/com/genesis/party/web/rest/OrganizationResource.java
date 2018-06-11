package com.genesis.party.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.genesis.party.domain.Organization;
import com.genesis.party.service.IOrganizationService;

//@RestController
//@RequestMapping("/organization")
public class OrganizationResource {

    private IOrganizationService organizationService;

	// @Inject
    public OrganizationResource(IOrganizationService organizationService) {
        this.organizationService = organizationService;
    }

	// @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization) {
        return new ResponseEntity<Organization>(organizationService.saveOrUpdate(organization), HttpStatus.CREATED);
    }
}
