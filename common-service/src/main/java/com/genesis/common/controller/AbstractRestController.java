package com.genesis.common.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.genesis.common.service.IGenericService;
import com.genesis.common.validator.ValidationGroup;

/**
 * 
 * @author palmurugan
 *
 */
public abstract class AbstractRestController<E, K> {

	private IGenericService<E, K> genericService;

	public AbstractRestController(IGenericService<E, K> genericService) {
		this.genericService = genericService;
	}

	@RequestMapping(method = POST)
	public ResponseEntity<E> create(@Validated(ValidationGroup.ValidateWhileCreate.class) @RequestBody E entity) {
		return new ResponseEntity<>(genericService.saveOrUpdate(entity), HttpStatus.CREATED);
	}

	@RequestMapping(method = GET)
	public ResponseEntity<Page<E>> getAllPartyType(Pageable pageable) {
		return new ResponseEntity<Page<E>>(genericService.getAll(pageable), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = GET)
	public ResponseEntity<E> getPartyType(@PathVariable K id) {
		return new ResponseEntity<E>(genericService.get(id).get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = PUT)
	public ResponseEntity<E> updatePartyType(@PathVariable K id, @Valid @RequestBody E entity) {
		return new ResponseEntity<E>(genericService.saveOrUpdate(entity), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = DELETE)
	public ResponseEntity<String> deletePartyType(@PathVariable K id) {
		genericService.remove(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
