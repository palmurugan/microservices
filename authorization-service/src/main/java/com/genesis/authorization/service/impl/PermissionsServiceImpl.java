package com.genesis.authorization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genesis.common.service.impl.GenericServiceImpl;
import com.genesis.authorization.repository.PermissionsRepository;
import com.genesis.authorization.domain.Permissions;
import com.genesis.authorization.service.PermissionsService;

/**
 * 
 * @author PalMurugan C
 *
 */
@Service
public class PermissionsServiceImpl extends GenericServiceImpl<Permissions, Long> implements PermissionsService {

	@Autowired
	private PermissionsRepository reference;

	public PermissionsServiceImpl(PermissionsRepository reference) {
		super(reference);
	}
}
