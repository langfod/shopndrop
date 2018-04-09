package com.dihelix.langfod.shopndrop;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {

	Optional<CartItem> findByCartAndProduct(Cart cart, Product product);
	Optional<CartItem> findByCartIdAndProductId(Long cartId, Long productId);

}
