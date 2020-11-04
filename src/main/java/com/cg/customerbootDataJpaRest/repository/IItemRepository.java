package com.cg.customerbootDataJpaRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.customerbootDataJpaRest.entities.Item;
public interface IItemRepository extends JpaRepository<Item,Long>{
	
}
