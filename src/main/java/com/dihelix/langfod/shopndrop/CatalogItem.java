package com.dihelix.langfod.shopndrop;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CatalogItem {

	@Id
	@GeneratedValue
	private Long id;
	private BigDecimal price = new BigDecimal(0);
	
	@OneToOne
	private Product product;
	private Integer quantity = 0;
	
	CatalogItem() {}

	public CatalogItem(Product product, BigDecimal price) {
		this.product = product;
		this.price = price;
	}
	
		
	public CatalogItem(Product product, BigDecimal price, int quantity) {
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}
	public void addProduct(int quantity) {
		quantity += quantity; 
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

	public void removeProduct(int quantity) {
		quantity -= quantity; // TODO should handle negative 
	}

}
