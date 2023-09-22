package com.nagarro.exittestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.exittestapi.model.Product;
import com.nagarro.exittestapi.model.Response;
import com.nagarro.exittestapi.service.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping(path = "/all")
	Response getAllProducts() {
		return service.getAllProducts();
	}

	@GetMapping(path = "/search/{query}")
	Response getProductsSearch(@PathVariable String query) {
		return service.getProductsSearch(query);

	}

	@PostMapping(path = "/create")
	Response createProduct(@RequestBody Product prod) {
		return service.createProduct(prod);
	}

	@GetMapping(path = "exists/{code}")
	Response exists(@PathVariable String code) {
		return service.exists(code);
	}

	@GetMapping(path = "/{code}")
	Response getProduct(@PathVariable String code) {
		return service.getProduct(code);
	}

	@GetMapping(path = "/count")
	Response count() {
		return service.count();
	}

}
