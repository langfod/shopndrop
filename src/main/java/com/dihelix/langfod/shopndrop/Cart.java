package com.dihelix.langfod.shopndrop;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Cart {
	
	
	@Transient
	private Logger log = LoggerFactory.getLogger(Cart.class);
	
	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<CartItem> cartItems = new LinkedHashSet<>();

    @NumberFormat(style = NumberFormat.Style.CURRENCY)
	private BigDecimal totalPrice = new BigDecimal(0);

	public Cart() {
	}

	public int getItemCount() {
		return cartItems.stream().map(CartItem::getQuantity).collect(Collectors.summingInt(i -> i));
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public Cart addCartItem(CartItem cartItem) {
		return addCartItem(cartItem, 1);
	}

	public Cart addCartItem(CartItem cartItem, int quantity) {
		if (cartItems.contains(cartItem)) {
			cartItem.updateQuantity(quantity);
		} else {
			cartItems.add(cartItem);
			cartItem.cart = this;			
		}
		updateTotalPrice();
		return this;
	}

	public Cart removeCartItem(CartItem cartItem, int quantity) {
		if (cartItems.contains(cartItem)) {
			cartItem.updateQuantity(-quantity);
			if (cartItem.getQuantity() <= 0 ) {
				cartItems.remove(cartItem);
				cartItem.cart = null;
			}
			updateTotalPrice();
		} 
		return this;
	}
	public Cart removeCartItem(CartItem cartItem) {
		return removeCartItem(cartItem, 1);
	}

	private void updateTotalPrice() {
		BigDecimal newValue = BigDecimal.ZERO;
		for (CartItem cartItem : cartItems) {
			 newValue = newValue.add(cartItem.getExtendedPrice());
		}
		totalPrice = newValue;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

}
