package com.cg.customerbootDataJpaRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.customerbootDataJpaRest.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
	

    List<Customer> findByFirstName(String name);
    List<Customer> findByLastName(String name);

    @Query("from Customer where firstName=:fname and lastName=:lname")
    List<Customer>findByFullName(@Param("fname") String firstName, @Param("lname") String lastName);


	

}
