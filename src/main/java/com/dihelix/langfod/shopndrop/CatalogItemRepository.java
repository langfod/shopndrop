package com.dihelix.langfod.shopndrop;

import org.springframework.data.repository.CrudRepository;

public interface CatalogItemRepository extends CrudRepository<CatalogItem, Long> {
	
	CatalogItem findByProduct(Product product);
	CatalogItem findByProductId(Long productId);


}
