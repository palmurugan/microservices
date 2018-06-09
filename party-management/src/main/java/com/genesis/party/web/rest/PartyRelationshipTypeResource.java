package com.genesis.party.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.common.controller.AbstractRestController;
import com.genesis.party.domain.PartyRelationshipType;
import com.genesis.party.service.IPartyRelationshipTypeService;

@RestController
@RequestMapping("/partyrelationshiptype")
public class PartyRelationshipTypeResource extends AbstractRestController<PartyRelationshipType, Long> {

	public PartyRelationshipTypeResource(IPartyRelationshipTypeService partyRelationshipTypeService) {
		super(partyRelationshipTypeService);
	}
}
