package com.genesis.party.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.common.controller.AbstractRestController;
import com.genesis.party.domain.PartyRelationship;
import com.genesis.party.service.IPartyRelationshipService;

/**
 * 
 * @author PalMurugan C
 *
 */
@RestController
@RequestMapping("/partyrelationship")
public class PartyRelationshipResource extends AbstractRestController<PartyRelationship, Long> {

    public PartyRelationshipResource(IPartyRelationshipService partyRelationshipService) {
		super(partyRelationshipService);
    }
}
