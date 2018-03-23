package com.dihelix.langfod.shopndrop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private Long id;

	private String description;
	
    @ElementCollection(targetClass=Image.class)
	private List<Image> images = new ArrayList<Image>();
	private String name;
	private BigDecimal price;
	
    @ElementCollection(targetClass=Review.class)
	private List<Review> reviews = new ArrayList<Review>();
    
	private String sku;
	
	private Spec spec;
	
	Product() {
		
	}
	
	public Product(String sku, String name) {
		this.sku = sku;
		this.name = name;
	}
	
	public Product(String sku, String name, String description, BigDecimal price) {
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public void addImage(Image image) {
		images.add(image);
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
