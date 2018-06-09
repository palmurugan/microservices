package com.genesis.party.web.rest;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.common.controller.AbstractRestController;
import com.genesis.party.domain.PartyType;
import com.genesis.party.service.IPartyTypeService;

/**
 * 
 * @author PalMurugan C
 *
 */

@RestController
@RequestMapping("/partytype")
public class PartyTypeResource extends AbstractRestController<PartyType, Long> {

	@Inject
    public PartyTypeResource(IPartyTypeService partyTypeService) {
		super(partyTypeService);
    }
}
