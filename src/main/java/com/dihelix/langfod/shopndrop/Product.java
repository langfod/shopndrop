package com.dihelix.langfod.shopndrop;

import java.math.BigDecimal;
import java.util.List;

public class Product {

	private String description;
	private Long id;
	private List<Image> images;
	private String name;
	private BigDecimal price;
	private List<Review> reviews;
	private String sku;
	private Spec spec;
	
	Product() {
		
	}
	
	public Product(String sku, String name) {
		this.sku = sku;
		this.name = name;
	}
	
	
	String getDescription() {
		return description;
	}
	Long getId() {
		return id;
	}
	List<Image> getImages() {
		return images;
	}
	String getName() {
		return name;
	}
	BigDecimal getPrice() {
		return price;
	}
	List<Review> getReviews() {
		return reviews;
	}
	String getSku() {
		return sku;
	}
	Spec getSpec() {
		return spec;
	}
	void setDescription(String description) {
		this.description = description;
	}
	void setImages(List<Image> images) {
		this.images = images;
	}
	void setName(String name) {
		this.name = name;
	}
	void setPrice(BigDecimal price) {
		this.price = price;
	}
	void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	void setSpec(Spec spec) {
		this.spec = spec;
	}
	
	
}
