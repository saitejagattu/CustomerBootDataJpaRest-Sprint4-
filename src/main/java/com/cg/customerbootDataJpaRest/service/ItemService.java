package com.cg.customerbootDataJpaRest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.customerbootDataJpaRest.entities.Customer;
import com.cg.customerbootDataJpaRest.entities.Item;
import com.cg.customerbootDataJpaRest.exceptions.CustomerNotFoundException;
import com.cg.customerbootDataJpaRest.exceptions.ItemAlreadyExistsException;
import com.cg.customerbootDataJpaRest.exceptions.ItemNotFoundException;
import com.cg.customerbootDataJpaRest.repository.ICustomerRepository;
import com.cg.customerbootDataJpaRest.repository.IItemRepository;
import com.cg.customerbootDataJpaRest.util.ItemValidationUtil;



@Service
@Transactional
public class ItemService implements IItemService{

	@Autowired 
	private IItemRepository repository;
	
	@Autowired
	private ICustomerRepository Customerrepo;
	

	@Override
	public Item add(Item item) {
		ItemValidationUtil.checkArgumentNotNull(item);
		ItemValidationUtil.checkDescriptionNotNull(item.getDescription());
		boolean exists = item.getId() != null && repository.existsById(item.getId());
		if (exists) {
			throw new ItemAlreadyExistsException("Item already exists for id=" + item.getId());
		}
		return repository.save(item);
	}

	@Override
	public Item update(Item item) {
			ItemValidationUtil.checkArgumentNotNull(item);
			ItemValidationUtil.checkDescriptionNotNull(item.getDescription());
			return repository.save(item);
		}

	@Override
	public Item buyItem(Long customerId, Long itemId) {
		 Item item=findById(itemId);
	      Optional<Customer>optionalCustomer=Customerrepo.findById(customerId);
	      if(!optionalCustomer.isPresent()){
	          throw new CustomerNotFoundException("student not found for id="+customerId);
	      }
	      Customer customer= optionalCustomer.get();
	      item.setCustomer(customer);
	      item=repository.save(item);
	      List<Item> items=customer.getItems();
	      if(items==null){
	          items=new ArrayList<>();
	          customer.setItems(items);
	      }
	      items.add(item);
	      return item;
	    }
		

	@Override
	public Item findById(Long id) {
		Optional<Item> itemobj=repository.findById(id);
		if (!itemobj.isPresent()) {
			throw new ItemNotFoundException("Item not found for id=" + id);
		}
		return itemobj.get();
	}

	
	}
	
	


