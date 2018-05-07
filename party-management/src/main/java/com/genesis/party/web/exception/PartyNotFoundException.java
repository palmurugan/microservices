package com.genesis.party.web.exception;

/**
 * 
 * @author palmurugan
 *
 */
public class PartyNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PartyNotFoundException() {
		super();
	}

	public PartyNotFoundException(String message) {
		super(message);
	}

	public PartyNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
