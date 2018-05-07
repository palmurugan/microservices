package com.genesis.party.web.exception;

/**
 * 
 * @author palmurugan
 *
 */
public class PartyTypeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PartyTypeNotFoundException() {
		super();
	}

	public PartyTypeNotFoundException(String message) {
		super(message);
	}

	public PartyTypeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
