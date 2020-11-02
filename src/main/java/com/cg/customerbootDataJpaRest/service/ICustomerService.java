package com.cg.customerbootDataJpaRest.service;

import java.util.List;

import com.cg.customerbootDataJpaRest.entities.Customer;



public interface ICustomerService {
	
	 Customer register(Customer customer);
	
	Customer findById(Long id);
	
	void deleteById(Long id);

	Customer update(Customer customer);

	List<Customer>findAll();

	List<Customer> findByFirstName(String name);

	List<Customer> findByLastName(String name);

	

}
