package com.genesis.common.dto;

import java.util.Date;

public class ErrorResponse {

	private String message;

	private Date timestamp;

	private String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", timestamp=" + timestamp + ", description=" + description + "]";
	}

}
