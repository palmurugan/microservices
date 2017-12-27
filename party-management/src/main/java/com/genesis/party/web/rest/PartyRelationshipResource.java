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

import com.genesis.party.domain.PartyRelationship;
import com.genesis.party.service.IPartyRelationshipService;

/**
 * 
 * @author PalMurugan C
 *
 */
@RestController
@RequestMapping("/partyrelationship")
public class PartyRelationshipResource {

    private IPartyRelationshipService partyRelationshipService;

    @Inject
    public PartyRelationshipResource(IPartyRelationshipService partyRelationshipService) {
        this.partyRelationshipService = partyRelationshipService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PartyRelationship> createRelationship(@RequestBody PartyRelationship partyRelationship) {
        return new ResponseEntity<PartyRelationship>(partyRelationshipService.saveOrUpdate(partyRelationship), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<PartyRelationship>> getAllRelationship(Pageable pageable) {
        return new ResponseEntity<Page<PartyRelationship>>(partyRelationshipService.getAll(pageable), HttpStatus.OK);
    }
}
