package com.cg.customerbootDataJpaRest.service;

import com.cg.customerbootDataJpaRest.entities.Item;

public interface IItemService {

	 Item add(Item item);
	 
	 Item update(Item item);
	 
	 Item findById(Long id);

	 Item buyItem(Long customerId, Long itemId);
	 
}
