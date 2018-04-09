package com.dihelix.langfod.shopndrop;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StorePopulator implements CommandLineRunner {

	@Resource
	ProductRepository productRepo;

	@Resource
	CatalogItemRepository catalogRepo;

	@Override
	public void run(String... args) throws Exception {

		// Image i = new Image("Fried Airball",
		// "http://via.placeholder.com/75x75?text=(Front)", "Front view of Fried
		// Airball", "http://via.placeholder.com/250x250?text=(Front)");
		String imageUrl = "http://via.placeholder.com/75x75?text=(Front)";

		Product product1 = new Product("F-AIR-01", "Fried Airballs", "Yummy balls of air, fried and crispy");
		Spec s = new Spec("Spec Title", "Spec Content");
		// Review r = new Review("Review Title", "Awsome Review Content", "Captain
		// Underpants");
		product1.setImage(imageUrl);
		product1 = product1.addSpec(s);
		// product1 = product1.addReview(r);
		product1 = productRepo.save(product1);
		CatalogItem item1 = new CatalogItem(product1, new BigDecimal("4.98"), 4);
		catalogRepo.save(item1);
		
		product1 = new Product("Bubbles-01", "Bubbles", "Bubbles! Lots of Fluffy Bubbles!");
		s = new Spec("Bubble Title", "Bubble Spec Content");
		product1.setImage("http://via.placeholder.com/75x75?text=(Bubbles)");
		product1 = product1.addSpec(s);
		product1 = productRepo.save(product1);
		item1 = new CatalogItem(product1, new BigDecimal("8.32"), 7);
		catalogRepo.save(item1);

	}

}
