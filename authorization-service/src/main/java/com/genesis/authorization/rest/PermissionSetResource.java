package com.genesis.authorization.rest;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.common.controller.AbstractRestController;
import com.genesis.authorization.domain.PermissionSet;
import com.genesis.authorization.service.PermissionSetService;

/**
 * 
 * @author PalMurugan C
 *
 */

@RestController
@RequestMapping("/permissionset")
public class PermissionSetResource extends AbstractRestController<PermissionSet, Long> {

	@Inject
    public PermissionSetResource(PermissionSetService reference) {
		super(reference);
    }
}
