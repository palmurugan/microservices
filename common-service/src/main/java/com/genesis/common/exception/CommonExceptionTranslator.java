package com.genesis.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.genesis.common.dto.ErrorResponse;
import com.genesis.common.util.ExceptionUtil;

/**
 * 
 * @author palmurugan
 *
 */
//@ControllerAdvice
public class CommonExceptionTranslator {

	/*@ExceptionHandler(MethodArgumentNotValidException.class)
	public final ResponseEntity<ErrorResponse> handleFieldErrors(MethodArgumentNotValidException exception,
			WebRequest request) {
		return new ResponseEntity<>(ExceptionUtil.buildErrorResponse(exception, request),
				HttpStatus.BAD_REQUEST);
	}*/
}
