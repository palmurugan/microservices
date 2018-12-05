package com.genesis.authorization.rest;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.common.controller.AbstractRestController;
import com.genesis.authorization.domain.Permissions;
import com.genesis.authorization.service.PermissionsService;

/**
 * 
 * @author PalMurugan C
 *
 */

@RestController
@RequestMapping("/permissions")
public class PermissionsResource extends AbstractRestController<Permissions, Long> {

	@Inject
    public PermissionsResource(PermissionsService reference) {
		super(reference);
    }
}
