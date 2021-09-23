package com.revature.errorhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ApiError {

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyy hh:mm:ss")
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	private String debugMessage;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDebugMessage() {
		return debugMessage;
	}
	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
	@Override
	public String toString() {
		return "ApiError [timestamp=" + timestamp + ", status=" + status + ", error=" + error + ", message=" + message
				+ ", debugMessage=" + debugMessage + "]";
	}
	
	// there might be sub errors(We'll create a class for this)
	List<ApiSubError> subErrors = new ArrayList<>();
	
	public ApiError() {
		super();
		this.timestamp = LocalDateTime.now();
	}
	
	
	public ApiError(HttpStatus status) {
		super();
		this.status = status.value(); // converts the status to the int number
		this.error = status.getReasonPhrase();
	}
	
	public ApiError(HttpStatus status, Throwable ex) {
		this(status); // this is constructor chaining -- we are doing everything that the abocve constructor is doing
		this.message = "No Message Available";
		this.debugMessage = ex.getLocalizedMessage(); // now we don't have to keep looking at our console, it'll be sent in the response
	}
	
	public ApiError(HttpStatus status, String message, Throwable ex) {
		this(status, ex);
		this.message = message;
	}
	
	public void addSubError(ApiSubError error) {
		this.subErrors.add(error);
	}
}
