package com.genesis.party.web.rest;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.party.domain.PartyType;
import com.genesis.party.service.IPartyTypeService;

/**
 * 
 * @author PalMurugan C
 *
 */

@RestController
@RequestMapping("/partytype")
public class PartyTypeResource {

    private IPartyTypeService partyTypeService;

    @Inject
    public PartyTypeResource(IPartyTypeService partyTypeService) {
        this.partyTypeService = partyTypeService;
    }

    @RequestMapping(method = POST)
    public ResponseEntity<PartyType> createPartyType(@RequestBody PartyType partyType) {
        return new ResponseEntity<>(partyTypeService.saveOrUpdatePartyType(partyType), HttpStatus.CREATED);
    }

    @RequestMapping(method = GET)
    public ResponseEntity<Page<PartyType>> getAllPartyType(Pageable pageable) {
        return new ResponseEntity<Page<PartyType>>(partyTypeService.getAllPartyTypeList(pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "/{partyTypeId}", method = GET)
    public ResponseEntity<PartyType> getPartyType(@PathVariable Long partyTypeId) {
        return new ResponseEntity<PartyType>(partyTypeService.getPartyType(partyTypeId), HttpStatus.OK);
    }

    @RequestMapping(value = "/{partyTypeId}", method = PUT)
    public ResponseEntity<PartyType> updatePartyType(@PathVariable Long partyTypeId, @RequestBody PartyType partyType) {
        partyType.setPartyTypeId(partyTypeId);
        return new ResponseEntity<PartyType>(partyTypeService.saveOrUpdatePartyType(partyType), HttpStatus.OK);
    }

    @RequestMapping(value = "/{partyTypeId}", method = DELETE)
    public ResponseEntity<String> deletePartyType(@PathVariable Long partyTypeId) {
        partyTypeService.deletePartyType(partyTypeId);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
