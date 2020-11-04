package com.cg.customerbootDataJpaRest.exceptions;

public class InvalidItemDescriptionException extends RuntimeException{

	public InvalidItemDescriptionException() {		
	}
	
	public InvalidItemDescriptionException (String msg) {
		super(msg);
	}

}
