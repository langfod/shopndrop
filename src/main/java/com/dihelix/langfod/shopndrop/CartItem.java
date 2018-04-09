package com.dihelix.langfod.shopndrop;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItem {

	@Id
	@GeneratedValue
	private Long id;
	private BigDecimal price = BigDecimal.ZERO;
	
	
	@ManyToOne
	private Product product;
	
	@JsonIgnore
	@ManyToOne Cart cart;
		
	public Cart getCart() {
		return cart;
	}

	private Integer quantity = 0;
	
	private BigDecimal extendedPrice = BigDecimal.ZERO;
	
	CartItem() {}

	public CartItem(Product product, BigDecimal price) {
		this.product = product;
		this.price = price;
		this.quantity = 1;
		updatextendedPrice();
	}
	

	public String getItemName() {
		return product.getName();
	}
	public void updateQuantity(int quantity) {
		this.quantity += quantity; 
		updatextendedPrice();
	}

	private void updatextendedPrice() {
		extendedPrice =  this.quantity > 0 ? price.multiply(new BigDecimal(this.quantity)) : BigDecimal.ZERO;
	}
	
	public Long getId() {
		return id;
	}

	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Product getProduct() {
		return product;
	}

	public Integer getProductQuantity() {
		return quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}


	public BigDecimal getExtendedPrice() {
		return extendedPrice;
	}

	public void removeProduct(int quantity) {
		quantity -= quantity; // TODO should handle negative 
		updatextendedPrice();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CartItem)) {
			return false;
		}
		CartItem other = (CartItem) obj;
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		if (product == null) {
			if (other.product != null) {
				return false;
			}
		} else if (!product.equals(other.product)) {
			return false;
		}
		return true;
	}

	
}
