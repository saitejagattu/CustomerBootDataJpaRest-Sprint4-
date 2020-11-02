package com.cg.customerbootDataJpaRest.exceptions;

public class InvalidCustomerNameException  extends RuntimeException {
	

	public InvalidCustomerNameException () {		
	}
	
	public InvalidCustomerNameException (String msg) {
		super(msg);
	}

}
