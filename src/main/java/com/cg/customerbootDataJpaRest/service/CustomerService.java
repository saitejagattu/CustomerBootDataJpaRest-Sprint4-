package com.cg.customerbootDataJpaRest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.customerbootDataJpaRest.entities.Customer;
import com.cg.customerbootDataJpaRest.exceptions.CustomerExistsException;
import com.cg.customerbootDataJpaRest.exceptions.CustomerNotFoundException;
import com.cg.customerbootDataJpaRest.repository.ICustomerRepository;
import com.cg.customerbootDataJpaRest.util.ValidationUtil;
import java.util.Optional;

@Transactional
@Service
public class CustomerService implements ICustomerService {

	@Autowired 
	private ICustomerRepository repository;
	
	
	@Override
	public Customer register(Customer customer) {
		 ValidationUtil.checkArgumentNotNull(customer);
	     ValidationUtil.checkName(customer.getFirstName(),customer.getLastName());
	     boolean exists=customer.getId()!=null && repository.existsById(customer.getId());
	     if(exists){
	        throw new CustomerExistsException("customer already exists for id="+customer.getId());
	        }
	        customer = repository.save(customer);
	        return customer;
	}

	@Override
	public Customer findById(Long id) {
		Optional<Customer> optional = repository.findById(id);
        if(!optional.isPresent()){
            throw new CustomerNotFoundException("customer not found for id="+id);
        }
        Customer customer=optional.get();
        return customer;
	}

	@Override
	public void deleteById(Long id) {
		Customer customer=findById(id);
		repository.delete(customer);
		
	}

	@Override
	public Customer update(Customer customer) {
		 ValidationUtil.checkArgumentNotNull(customer);
	     ValidationUtil.checkName(customer.getFirstName(), customer.getLastName());
	     customer = repository.save(customer);
	     return customer;
	}

	@Override
	public List<Customer> findAll() {
		 List<Customer> list = repository.findAll();
	     return list;
	}

	@Override
	public List<Customer> findByFirstName(String firstName) {
		List<Customer> customer=repository.findByFirstName(firstName);
        return customer;
	}

	@Override
	public List<Customer> findByLastName(String lastName) {
		 List<Customer>customer=repository.findByLastName(lastName);
	     return customer;
	}

	
	

}
