package com.gee.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class GeeAuthException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8639925468241362445L;
	
	public GeeAuthException(){
		super();
	}
	
	public GeeAuthException(String message){
		super(message);
	}

}
