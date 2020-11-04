package com.cg.customerbootDataJpaRest.util;

import com.cg.customerbootDataJpaRest.exceptions.InvalidArgumentException;
import com.cg.customerbootDataJpaRest.exceptions.InvalidItemDescriptionException;

public class ItemValidationUtil {
	
	public static void checkArgumentNotNull(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("arg can't be null");
		}
	}

	public static void checkDescriptionNotNull(String description) {
		if (description == null || description.isEmpty()) {
			throw new InvalidItemDescriptionException("Description is not valid");
		}
 
	}


}
