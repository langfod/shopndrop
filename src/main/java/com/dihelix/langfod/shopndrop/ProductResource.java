package com.dihelix.langfod.shopndrop;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class ProductResource extends ResourceSupport {
	
	private final Product product;
	
	public ProductResource(Product product) {
		this.product = product;
		//this.add(linkTo(ShopndropController.class, product.getImages()).withRel("api/product"));
	}
	
	public Product getProduct() {
		return product;
	}

}
