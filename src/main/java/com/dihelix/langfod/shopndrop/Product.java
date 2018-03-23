package com.dihelix.langfod.shopndrop;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
public class Product  {

	@Id
	@GeneratedValue
	private Long id;

	private String description;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Image> images = new LinkedHashSet<Image>();
	private String name;
	private BigDecimal price;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Review> reviews = new LinkedHashSet<Review>();

	private String sku;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
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

	public Product addImage(Image image) {
		images.add(image);
		image.products.add(this);
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public Set<Image> getImages() {
		return images;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public String getSku() {
		return sku;
	}

	public Spec getSpec() {
		return spec;
	}

	void setDescription(String description) {
		this.description = description;
	}

	void setName(String name) {
		this.name = name;
	}

	void setPrice(BigDecimal price) {
		this.price = price;
	}

	void setSpec(Spec spec) {
		this.spec = spec;
	}

	public Product addSpec(Spec spec) {
		this.spec = spec;
		spec.products.add(this);
		return this;
	}

	public Product addReview(Review review) {
		reviews.add(review);
		review.products.add(this);
		return this;
	}

}
