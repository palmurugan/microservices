package com.genesis.party.web.rest;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.party.domain.PartyRelationshipType;
import com.genesis.party.service.IPartyRelationshipTypeService;

@RestController
@RequestMapping("/partyrelationshiptype")
public class PartyRelationshipTypeResource {

	private IPartyRelationshipTypeService partyRelationshipTypeService;

	@Inject
	public PartyRelationshipTypeResource(IPartyRelationshipTypeService partyRelationshipTypeService) {
		this.partyRelationshipTypeService = partyRelationshipTypeService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PartyRelationshipType> createRelationshipType(
			@RequestBody PartyRelationshipType partyRelationshipType) {
		return new ResponseEntity<PartyRelationshipType>(
				partyRelationshipTypeService.saveOrUpdate(partyRelationshipType), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<PartyRelationshipType>> getAllRelationshipType(Pageable pageable) {
		return new ResponseEntity<Page<PartyRelationshipType>>(partyRelationshipTypeService.getAll(pageable),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PartyRelationshipType> updateRelationshipType(
			@RequestBody PartyRelationshipType partyRelationshipType, @PathVariable Long id) {
		return new ResponseEntity<PartyRelationshipType>(
				partyRelationshipTypeService.saveOrUpdate(setPartyRelationshipType(partyRelationshipType, id)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PartyRelationshipType> getPartyRelationshipType(@PathVariable Long id) {
		return new ResponseEntity<PartyRelationshipType>(partyRelationshipTypeService.get(id).get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removePartyRelationshipType(@PathVariable Long id) {
		partyRelationshipTypeService.remove(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	private PartyRelationshipType setPartyRelationshipType(PartyRelationshipType partyRelationshipType,
			Long partyRelationshipTypeId) {
		partyRelationshipType.setPartyRelationshipTypeId(partyRelationshipTypeId);
		return partyRelationshipType;
	}
}
