package com.cg.customerbootDataJpaRest.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.customerbootDataJpaRest.Dto.ItemDetails;
import com.cg.customerbootDataJpaRest.entities.Customer;
import com.cg.customerbootDataJpaRest.entities.Item;

@Component
public class ItemUtil {
	
	 public static ItemDetails toItemDetails(Item item){
		 
		 ItemDetails details=new ItemDetails();
	     details.setId(item.getId());
	     details.setDescription(item.getDescription());
	        Customer customer=item.getCustomer();
	        if(customer!=null) {
	        	 details.setFirstName(customer.getFirstName());
	             details.setLastName(customer.getLastName());
	             details.setCustomerId(customer.getId());
	        }
	        return details;
	 }
	 
	  public List<ItemDetails> toItemDetailsList(Collection<Item>items){
	        List<ItemDetails>listofItems=new ArrayList<>();
	        for (Item item:items){
	          ItemDetails details= toItemDetails(item);
	          listofItems.add(details);
	        }
	        return listofItems;
	    }
	  
	  
	
	

}
