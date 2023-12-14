package org.cap.bim.repository;

import java.util.List;

import org.cap.bim.model.ShoppingCart;
import org.cap.bim.model.ShoppingCartKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShoppingCartRepository extends JpaRepository<ShoppingCart, ShoppingCartKey>{
	
	List<ShoppingCart> findByUserId (Integer userId);
}
