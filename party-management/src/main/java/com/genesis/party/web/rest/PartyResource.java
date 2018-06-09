package com.genesis.party.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.common.controller.AbstractRestController;
import com.genesis.party.domain.Party;
import com.genesis.party.service.IPartyService;

/**
 * 
 * @author PalMurugan C
 *
 */

@RestController
@RequestMapping(value = "/party")
public class PartyResource extends AbstractRestController<Party, Long> {

	public PartyResource(IPartyService partyService) {
		super(partyService);
	}
}
