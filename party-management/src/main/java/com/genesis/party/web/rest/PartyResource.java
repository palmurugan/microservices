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

import com.genesis.party.domain.Party;
import com.genesis.party.service.IPartyService;

/**
 * 
 * @author PalMurugan C
 *
 */

@RestController
@RequestMapping(value = "/party")
public class PartyResource {

    private IPartyService partyService;

    @Inject
    public PartyResource(IPartyService partyService) {
        this.partyService = partyService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Party> createParty(@RequestBody Party party) {
        return new ResponseEntity<Party>(partyService.saveOrUpdate(party), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Party>> getAllParty(Pageable pageable) {
        return new ResponseEntity<Page<Party>>(partyService.getAll(pageable), HttpStatus.OK);
    }
}
