package com.genesis.common.dto;

import java.util.Date;
import java.util.List;

public class FieldError {

	private String message;
	
	private Date timestamp;
	
	private List<String> errors;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public FieldError(String message, Date timestamp, List<String> errors) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.errors = errors;
	}

	public FieldError() {
	}

	@Override
	public String toString() {
		return "FieldError [message=" + message + ", timestamp=" + timestamp + ", errors=" + errors + "]";
	}
}
