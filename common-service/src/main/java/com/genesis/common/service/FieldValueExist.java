package com.genesis.common.service;

/**
 * 
 * @author palmurugan
 *
 */
public interface FieldValueExist {

	/**
	 * 
	 * @param value
	 * @param fieldName
	 * @return
	 * @throws UnsupportedOperationException
	 */
	boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException;
}
