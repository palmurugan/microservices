package com.genesis.common.configuration;

import org.springframework.data.domain.AuditorAware;

/**
 * 
 * @author PalMurugan C
 *
 */

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		// TODO make this name dynamic from security context
		return "Admin";
	}
}
