package com.nagarro.exittestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.nagarro.exittestapi.model.Product;
import com.nagarro.exittestapi.model.Response;
import com.nagarro.exittestapi.repo.ProductRepo;

@Repository 
public class ProductService {
	@Autowired
	ProductRepo repo;

	public Response getAllProducts() {

		Response response = new Response();
		List<Product> data = repo.findAll();
		response.setData(data);
		response.setSuccess(true);
		response.setMessage("All Data");
		return response;

	}

	public Response getProductsSearch(String query) {

		Response response = new Response();
		List<Product> data = repo.findAll();
		data.removeIf(
				t -> !(t.getBrand().contains(query) || t.getCode().contains(query) || t.getName().contains(query)));

		response.setData(data);
		response.setSuccess(true);
		response.setMessage("All Data which contains " + query);
		return response;

	}

	public Response createProduct(@RequestBody Product prod) {

		Response response = new Response();
		if (repo.existsById(prod.getCode())) {
			response.setData(repo.findById(prod.getCode()));
			response.setMessage("Product code already Exist, Time to wait");
			response.setSuccess(false);
		} else {
			repo.save(prod);
			response.setData(prod);
			response.setSuccess(true);
			response.setMessage("Saved Successfully");
		}
		return response;
	}

	public Response exists(@PathVariable String code) {
		Response response = new Response();
		if (repo.findById(code).isPresent()) {
			response.setData(repo.findById(code).get());
			response.setMessage("Already Esists");
			response.setSuccess(true);
		} else {
			response.setData("not found");
			response.setSuccess(false);
		}
		return response;
	}

	public Response getProduct(@PathVariable String code) {
		Response response = new Response(repo.findById(code).get());
		return response;
	}

	public Response count() {
		return new Response(repo.count());
	}

}
