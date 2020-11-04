package com.cg.customerbootDataJpaRest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customerbootDataJpaRest.Dto.AddItem;
import com.cg.customerbootDataJpaRest.Dto.ItemAllot;
import com.cg.customerbootDataJpaRest.Dto.ItemDetails;
import com.cg.customerbootDataJpaRest.entities.Item;
import com.cg.customerbootDataJpaRest.service.IItemService;
import com.cg.customerbootDataJpaRest.util.ItemUtil;

@RequestMapping("/items")
@RestController
@Validated
public class ItemController {
	
	@Autowired
	private IItemService itemService;
	
	@ResponseStatus(HttpStatus.CREATED)
	 @PostMapping("/add")
	 public ItemDetails add(@RequestBody @Valid AddItem requestData){
		Item item=new Item();
		item.setDescription(requestData.getDescription());
		itemService.add(item);
		ItemDetails itemDetails=ItemUtil.toItemDetails(item);
		return itemDetails;
	    }
	@PutMapping("/update")
	public ItemDetails update(@RequestBody @Valid ItemDetails updateItem) {
		Item item = new Item();
		item.setId(updateItem.getId());
		item.setDescription(updateItem.getDescription());
		itemService.update(item);
		return updateItem;
	}
	 
	    @PutMapping("/buyitem")
	    public ItemDetails allot(@RequestBody @Valid ItemAllot request){
	       Item item= itemService.buyItem(request.getItemId(), request.getCustomerId());
	       ItemDetails details=ItemUtil.toItemDetails(item);
	       return details;
	    }
	    
	    

}
