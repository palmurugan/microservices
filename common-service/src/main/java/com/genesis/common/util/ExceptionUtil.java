package com.genesis.common.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import com.genesis.common.dto.ErrorResponse;
import com.genesis.common.dto.FieldError;
/**
 * 
 * @author palmurugan
 *
 */
public class ExceptionUtil {

	private static final String VALIDATION_FAILED = "Validation Failed!";

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

	public static FieldError buildFieldErrorResponse(MethodArgumentNotValidException excepion, WebRequest webRequest) {
		FieldError fieldError = new FieldError();
		List<String> errors = new ArrayList<>();
		for (org.springframework.validation.FieldError fldError : excepion.getBindingResult().getFieldErrors()) {
			errors.add(fldError.getField() + " : " + fldError.getDefaultMessage());
		}
		fieldError.setErrors(errors);
		fieldError.setTimestamp(new Date());
		fieldError.setMessage(VALIDATION_FAILED);
		return fieldError;
	}
}
