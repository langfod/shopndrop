package com.dihelix.langfod.shopndrop;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ManyToMany;
import javax.persistence.MapKey;

public class Catalog {

	private Long id;
	
	@ManyToMany
	@MapKey(name = "title")
	private Map<Product, Integer> catalogItems = new HashMap<>();

	public Map<Product, Integer> getCatalogItems() {
		return catalogItems;
	}

	public void addItemFromCatalog(Product product, int quantity) {
		int oldQuantity = catalogItems.getOrDefault(product, 0);
		catalogItems.put(product, oldQuantity + quantity);
	}

	public void removeItemFromCatalog(Product product, int quantity) {
		int oldQuantity = catalogItems.getOrDefault(product, 0);
		catalogItems.put(product, oldQuantity - quantity);
	}

	public Long getId() {
		return id;
	}

}
