package com.cg.customerbootDataJpaRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class CustomerbootDataJpaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerbootDataJpaRestApplication.class, args);
	}

}
