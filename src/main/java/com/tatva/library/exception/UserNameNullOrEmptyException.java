package com.tatva.library.exception;

public class UserNameNullOrEmptyException extends RuntimeException{
	
	public UserNameNullOrEmptyException(String msg){
		super(msg);
	}
}
