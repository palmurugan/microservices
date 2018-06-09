package com.genesis.party.web.exception;

import static com.genesis.common.util.ExceptionUtil.buildErrorResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.genesis.common.dto.ErrorResponse;
import com.genesis.common.dto.FieldError;

/**
 * 
 * @author palmurugan
 *
 */
@ControllerAdvice
public class PartyExceptionTransalator {

	private static final String VALIDATION_FAILED = "Validation Failed!";

	@ExceptionHandler(PartyManagementException.class)
	public final ResponseEntity<ErrorResponse> handlePartyManagementException(
			PartyManagementException partyManagementException, WebRequest request) {
		return new ResponseEntity<>(buildErrorResponse(partyManagementException, request),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(PartyNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handlePartyNotFoundException(
			PartyNotFoundException partyNotFoundException, WebRequest request) {
		return new ResponseEntity<>(buildErrorResponse(partyNotFoundException, request), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PartyTypeNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handlePartyTypeNotFoundException(
			PartyTypeNotFoundException partyTypeNotFoundException, WebRequest request) {
		return new ResponseEntity<>(buildErrorResponse(partyTypeNotFoundException, request), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public final ResponseEntity<FieldError> handleFieldErrors(MethodArgumentNotValidException exception,
			WebRequest request) {
		return new ResponseEntity<>(buildFieldErrorResponse(exception, request), HttpStatus.BAD_REQUEST);
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
