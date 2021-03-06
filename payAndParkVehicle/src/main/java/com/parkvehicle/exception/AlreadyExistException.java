package com.parkvehicle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class AlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlreadyExistException(String ex) {
		super(ex);
	}
	
	public AlreadyExistException(Throwable t,String ex) {
		super(ex,t);
	}
	
	
}
