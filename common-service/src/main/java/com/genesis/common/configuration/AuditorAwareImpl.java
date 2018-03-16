package com.genesis.common.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

/**
 * 
 * @author PalMurugan C
 *
 */

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // TODO make this name dynamic from security context
        return Optional.of("Admin");
    }
}
