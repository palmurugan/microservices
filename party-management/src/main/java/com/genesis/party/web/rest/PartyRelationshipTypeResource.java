package com.genesis.party.web.rest;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.party.domain.PartyRelationshipType;
import com.genesis.party.service.IPartyRelationshipTypeService;

@RestController
@RequestMapping("/partyrelationshiptype")
public class PartyRelationshipTypeResource {

    private IPartyRelationshipTypeService partyRelationshipService;

    @Inject
    public PartyRelationshipTypeResource(IPartyRelationshipTypeService partyRelationshipService) {
        this.partyRelationshipService = partyRelationshipService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PartyRelationshipType> createRelationshipType(@RequestBody PartyRelationshipType partyRelationshipType) {
        return new ResponseEntity<PartyRelationshipType>(partyRelationshipService.saveOrUpdate(partyRelationshipType), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<PartyRelationshipType>> getAllRelationshipType(Pageable pageable) {
        return new ResponseEntity<Page<PartyRelationshipType>>(partyRelationshipService.getAll(pageable), HttpStatus.OK);
    }
}
