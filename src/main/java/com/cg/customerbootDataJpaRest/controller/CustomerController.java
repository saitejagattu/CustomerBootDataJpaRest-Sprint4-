package com.cg.customerbootDataJpaRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customerbootDataJpaRest.Dto.CreateCustomerRequest;
import com.cg.customerbootDataJpaRest.Dto.CustomerDetails;
import com.cg.customerbootDataJpaRest.Dto.UpdateCustomer;
import com.cg.customerbootDataJpaRest.entities.Customer;
import com.cg.customerbootDataJpaRest.service.ICustomerService;
import com.cg.customerbootDataJpaRest.util.CustomerUtil;

import java.util.List;

@Validated
@RequestMapping("/customer")
@RestController
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	
	@Autowired
	private CustomerUtil customerUtil;
	
		@ResponseStatus(HttpStatus.CREATED)
	    @PostMapping("/add")
	    public CustomerDetails add(@RequestBody CreateCustomerRequest requestData) {
		Customer customer = new Customer(requestData.getFirstName(), requestData.getLastName());
		customer = service.register(customer);
	    CustomerDetails details = customerUtil.toDetails(customer);
	    return details;
	    }

	    @PutMapping("/update")
	    public CustomerDetails update(@RequestBody  UpdateCustomer requestData) {
	    Customer customer= new Customer(requestData.getFirstName(), requestData.getLastName());
	    customer.setId(requestData.getId()); 
	    customer = service.update(customer);
	    CustomerDetails details = customerUtil.toDetails(customer);
	    return details;
	    }


	    @GetMapping("/by/id/{id}")
	    public CustomerDetails fetchCustomer(@PathVariable("id") Long id) {
	        Customer customer = service.findById(id);
	        CustomerDetails details = customerUtil.toDetails(customer);
	        return details;
	    }


	    @GetMapping("/by/firstname/{name}")
	    public List<CustomerDetails> findCustomerByName(@PathVariable("name") String name) {
	        List<Customer> customer = service.findByFirstName(name);
	        List<CustomerDetails> result = customerUtil.toDetails(customer);
	        return result;
	    }

	    @GetMapping
	    public List<CustomerDetails> fetchAll() {
	        List<Customer> customer = service.findAll();
	        List<CustomerDetails>  result= customerUtil.toDetails(customer);
	        return  result;
	    }


	    @DeleteMapping("/remove/{id}")
	    public String removeCustomer(@PathVariable("id") Long id) {
	        service.deleteById(id);
	        String  result= "removed customer with id=" + id;
	        return  result;
	    }
	

}
