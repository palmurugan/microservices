package com.genesis.authorization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genesis.common.service.impl.GenericServiceImpl;
import com.genesis.authorization.repository.PermissionSetRepository;
import com.genesis.authorization.domain.PermissionSet;
import com.genesis.authorization.service.PermissionSetService;

/**
 * 
 * @author PalMurugan C
 *
 */
@Service
public class PermissionSetServiceImpl extends GenericServiceImpl<PermissionSet, Long> implements PermissionSetService {

	@Autowired
	private PermissionSetRepository reference;

	public PermissionSetServiceImpl(PermissionSetRepository reference) {
		super(reference);
	}
}
