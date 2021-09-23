package com.revature.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.revature.errorhandler.ApiError;
import com.revature.errorhandler.ApiValidationError;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	// this is a custom method that's going to help us send back the api error as a response 
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError){
		return ResponseEntity.status(apiError.getStatus()).body(apiError);
	}
	/**
	 * What happends if a user uses a POST request to send and INVALID User object
	 * which defies some Validation that we set up in the model
	 */
	
	//This is designed to capture any exception that might occur when a contriller method takes in a "bad" object
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String error = "Request failed validation";
		
		//instantiate an ApiError object 
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, error, ex);
		
		// Next we can find out exactly WHAT went wrong? Password? Email? 
		
		// 1. capture MethodArgumentNotValidException ex, and iterate over all the field errors
		for(FieldError e : ex.getFieldErrors()) {
			apiError.addSubError(new ApiValidationError(e.getObjectName(), e.getDefaultMessage(), e.getField(), e.getRejectedValue()));
		}
		
		//send back apiError as the response entity 
		return buildResponseEntity(apiError);
	}
	
	/**
	 * Intercepts exceptions that are caused by Invalid JSON
	 * Send back a 4xx indication the client side error
	 */
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		String error = "Malformed JSON request!";
		
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	}
}
