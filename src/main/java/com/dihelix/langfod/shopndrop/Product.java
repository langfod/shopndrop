package com.dihelix.langfod.shopndrop;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	private String description;

	//@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	//private Set<Image> images = new LinkedHashSet<Image>();

	private String image;

	//@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	//private Set<Review> reviews = new LinkedHashSet<Review>();

	private String sku;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Spec spec;
	
	@JsonIgnore
	@OneToOne
	private CatalogItem catalogItem;

	Product() {

	}

	public Product(String sku, String name) {
		this.sku = sku;
		this.name = name;
	}

	public Product(String sku, String name, String description) {
		this.sku = sku;
		this.name = name;
		this.description = description;
	}

	/*
	public Product addImage(Image image) {
		images.add(image);
		image.products.add(this);
		return this;
	}
	*/


	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}
/*
	public Set<String> getImages() {
		return images;
	}
*/
	public String getName() {
		return name;
	}
public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	/*
	public Set<Review> getReviews() {
		return reviews;
	}
	
		public Product addReview(Review review) {
		reviews.add(review);
		review.products.add(this);
		return this;
	}
*/
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

	
	void setSpec(Spec spec) {
		this.spec = spec;
	}

	public Product addSpec(Spec spec) {
		this.spec = spec;
		spec.products.add(this);
		return this;
	}



}
