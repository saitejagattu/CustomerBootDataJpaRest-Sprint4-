package com.cg.customerbootDataJpaRest.exceptions;

public class CustomerExistsException extends RuntimeException{

	
	 public CustomerExistsException()  {

	    }

	    public CustomerExistsException(String msg){
	        super(msg);
	    }
}
