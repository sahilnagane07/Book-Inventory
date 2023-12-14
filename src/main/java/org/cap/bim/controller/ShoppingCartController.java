package org.cap.bim.controller;

import java.util.List;

import org.cap.bim.model.PurchaseLogDTO;
import org.cap.bim.model.ShoppingCart;
import org.cap.bim.model.ShoppingCartDTO;
import org.cap.bim.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/shoppingcart")
@RestController
public class ShoppingCartController {
	@Autowired
	private IShoppingCartService shoppingCartService;
	
	@PostMapping("/post")
	public ResponseEntity<String> addToCart(@RequestBody ShoppingCartDTO shoppingCartDto){
		ShoppingCart shoppingCart=shoppingCartService.addToCart(shoppingCartDto);
		if(shoppingCart!=null) {
			return new ResponseEntity<String>("Shopping cart added successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("ShoppingCart creation error!",HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("{userId}")
	public ResponseEntity <List<ShoppingCartDTO>> getCartByUserId(@PathVariable ("userId") Integer userId){
		List<ShoppingCartDTO> shoppingCarts=shoppingCartService.getCartByUserId(userId);
		if(shoppingCarts.isEmpty()) {
			return new ResponseEntity("ShoppingCart is not found for the userId : "+userId,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ShoppingCartDTO>>(shoppingCarts,HttpStatus.OK);
	}
	
	@PutMapping("/update/isbn/{userId}")
	public ResponseEntity<List<ShoppingCartDTO>> updateISBNByUserId(@PathVariable ("userId") Integer userId ,@RequestBody ShoppingCartDTO shoppingCartDto){
		List<ShoppingCartDTO> shoppingCarts=shoppingCartService.updateISBNByUserId(userId, shoppingCartDto);
		if(shoppingCarts.isEmpty()) {
			return new ResponseEntity("ShoppingCart is not found for the userId : "+userId,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ShoppingCartDTO>>(shoppingCarts,HttpStatus.OK);
	}
}
