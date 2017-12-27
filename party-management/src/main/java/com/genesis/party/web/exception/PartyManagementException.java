package com.genesis.party.web.exception;

/**
 * 
 * @author PalMurugan C
 *
 */
public class PartyManagementException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public PartyManagementException() {

    }

    public PartyManagementException(String message) {
        super(message);
    }

    public PartyManagementException(String message, Throwable cause) {
        super(message, cause);
    }
}
