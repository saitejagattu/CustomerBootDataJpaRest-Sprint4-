package com.cg.customerbootDataJpaRest.util;

import com.cg.customerbootDataJpaRest.exceptions.InvalidArgumentException;
import com.cg.customerbootDataJpaRest.exceptions.InvalidCustomerNameException;

public class ValidationUtil {
	
	public static void checkArgumentNotNull(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("arg can't be null");
		}
	}

	public static void checkName(String firstName , String lastName) {
		if (firstName == null || firstName.isEmpty() || lastName==null|| lastName.isEmpty()) {
			throw new InvalidCustomerNameException("name is not valid");
		}

	}



}
