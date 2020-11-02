package com.cg.customerbootDataJpaRest.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.customerbootDataJpaRest.Dto.CustomerDetails;
import com.cg.customerbootDataJpaRest.entities.Customer;

@Component
public class CustomerUtil {
	
	 public List<CustomerDetails> toDetails(Collection<Customer> customer) {
	        List<CustomerDetails> listofCustomer = new ArrayList<>();
	        for (Customer customer1 : customer) {
	        	CustomerDetails details = toDetails(customer1);
	        	listofCustomer.add(details);
	        }
	        return listofCustomer;
	    }

	    public CustomerDetails toDetails(Customer customer) {
	    	CustomerDetails details = new CustomerDetails(customer.getId(), customer.getFirstName(), customer.getLastName());
	        return details;

	    }


}
