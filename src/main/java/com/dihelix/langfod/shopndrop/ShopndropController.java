package com.dihelix.langfod.shopndrop;

import java.util.Comparator;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShopndropController {

	private Logger log = LoggerFactory.getLogger(ShopndropController.class);

	@Resource
	ProductRepository productRepository;

	@Resource
	CartRepository cartRepository;

	@Resource
	CartItemRepository cartItemRepository;

	@Resource
	CatalogItemRepository catalogItemRepository;

	/* ----------------------------------- */
	/* Resty Stuff */
	/* ----------------------------------- */

	@ResponseBody
	@GetMapping(value = "/api/catalog")
	public HttpEntity<Iterable<CatalogItem>> findAllCatlogItems() {
		Iterable<CatalogItem> items = catalogItemRepository.findAll();
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(value = "/api/products")
	public HttpEntity<Iterable<Product>> findAllProducts() {
		Iterable<Product> products = productRepository.findAll();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(value = "/api/product/{productId}")
	public HttpEntity<Product> findProduct(@PathVariable("productId") Long productId) {
		Product product = productRepository.findById(productId).get();
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(value = "/api/cart")
	public HttpEntity<Cart> getNewCart() {
		Cart newCart = cartRepository.save(new Cart());
		return new ResponseEntity<>(newCart, HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(value = "/api/cart/{cartId}")
	public HttpEntity<Cart> getCartContents(@PathVariable("cartId") Long cartId) {
		Cart cart = cartRepository.findById(cartId).get();
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	@ResponseBody
	@PutMapping(value = "/api/cart/{cartId}/{productId}")
	public HttpEntity<String> addProductToCart(@PathVariable(value = "cartId") Long cartId,	@PathVariable(value = "productId") Long productId) {
		Product product = productRepository.findById(productId).get();
		CatalogItem catalogItem = catalogItemRepository.findByProductId(productId);  //TODO not precise
		
		Cart cart = cartRepository.findById(cartId).get();
		
		CartItem cartItem = cartItemRepository.findByCartIdAndProductId(cartId, productId)
				.orElseGet(() -> cartItemRepository.save(new CartItem(product, catalogItem.getPrice())));
		
		cart = cartRepository.save(cart.addCartItem(cartItem, 1));
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@ResponseBody
	@DeleteMapping(value = "/api/cart/{cartId}/{cartItemId}")
	public ResponseEntity<String> apiDeleteItemFromCart(@PathVariable("cartId") Long cartId,
			@PathVariable("cartItemId") Long cartItemId) {
		Cart cart = cartRepository.findById(cartId).get();
		cartRepository.save(cart.removeCartItem(cartItemRepository.findById(cartItemId).get()));
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	/* ----------------------------------- */
	/* Not Resty Stuff */
	/* ----------------------------------- */

	@GetMapping(value = { "/", "/store", "/catalog" })
	public String frontPage(Model model) {
		Iterable<CatalogItem> items = catalogItemRepository.findAll();
		model.addAttribute("items", items);
		return "store";
	}

	@GetMapping(value = "/cart/{cartId}")
	public String getCartItemsPage(@PathVariable("cartId") Long cartId, Model model) {
		Cart cart = cartRepository.findById(cartId).get();
		model.addAttribute("cart", cart);
		model.addAttribute("priceComp", Comparator.comparing(CartItem::getItemName));
		return "fragments/cartItems::cartItems";
	}

}
