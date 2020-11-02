package com.cg.customerbootDataJpaRest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.customerbootDataJpaRest.entities.Customer;
import com.cg.customerbootDataJpaRest.exceptions.InvalidArgumentException;
import com.cg.customerbootDataJpaRest.service.CustomerService;
import com.cg.customerbootDataJpaRest.service.ICustomerService;

import org.junit.jupiter.api.function.Executable;
import java.util.*;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(CustomerService.class)
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerbootDataJpaRestApplicationTests {

	@Autowired
	ICustomerService service;
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	void registerTest() {
		 String firstName="Ramesh", lastName="Suresh";
	        Customer customer=new Customer(firstName,lastName);
	        customer=service.register(customer);
	        TypedQuery<Customer>query= entityManager.createQuery("from Customer", Customer.class);
	        List<Customer>list=query.getResultList();
	        Assertions.assertEquals(1,list.size());
	        Customer stored=list.get(0);
	        Assertions.assertEquals(customer.getId(),stored.getId());
	        Assertions.assertEquals(firstName,stored.getFirstName());
	        Assertions.assertEquals(lastName,stored.getLastName());
	       
	}
	 
	 @Test
	    public void findByIdtest(){
	        String firstName="Raja", lastName="Ramu";
	        int age=21;
	        Customer customer=new Customer(firstName,lastName);
	        entityManager.persist(customer);
	        Long id=customer.getId();
	        Customer result=service.findById(id);
	        Assertions.assertEquals(id,result.getId());
	        Assertions.assertEquals(firstName,result.getFirstName());
	        Assertions.assertEquals(lastName,result.getLastName());
	 }
	 
	 @Test
	    public void nullValueTest(){
	        Customer customer=null;
	        Executable executable=()-> service.register(customer);
	        Assertions.assertThrows(InvalidArgumentException.class,executable);
	    }
	 
	

}
