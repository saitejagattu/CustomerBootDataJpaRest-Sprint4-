package com.cg.customerbootDataJpaRest.exceptions;

public class ItemAlreadyExistsException extends RuntimeException {

	 public ItemAlreadyExistsException()  {

	    }

	    public ItemAlreadyExistsException(String msg){
	        super(msg);
	    }

}
