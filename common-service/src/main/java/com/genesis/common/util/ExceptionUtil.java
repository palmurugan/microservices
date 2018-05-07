package com.genesis.common.util;

import java.util.Date;

import org.springframework.web.context.request.WebRequest;

import com.genesis.common.dto.ErrorResponse;
/**
 * 
 * @author palmurugan
 *
 */
public class ExceptionUtil {

	public static <T extends RuntimeException> ErrorResponse buildErrorResponse(T excepion, WebRequest webRequest) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(excepion.getMessage());
		errorResponse.setDescription(webRequest.getDescription(false));
		errorResponse.setTimestamp(new Date());
		return errorResponse;
	}
	
	public static <T extends Exception> ErrorResponse buildErrorResponse(T excepion, WebRequest webRequest) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(excepion.getMessage());
		errorResponse.setDescription(webRequest.getDescription(false));
		errorResponse.setTimestamp(new Date());
		return errorResponse;
	}
}
