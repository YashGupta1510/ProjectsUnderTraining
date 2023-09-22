package com.nagarro.advanceJava5API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.advanceJava5API.Repo.BookRepo;
import com.nagarro.advanceJava5API.model.Book;
import com.nagarro.advanceJava5API.model.Response;

@RestController
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	BookRepo repo;

	@GetMapping
	public Response getAllBooks() {
		Response response = new Response();
		response.setData(repo.findAll());
		return response;
	}

	@PostMapping
	public Response addBook(@RequestBody Book book) {
		repo.save(book);
		Response response = new Response();
		response.setData(book);
		return response;
	}

	@GetMapping(value = "/{code}")
	public Response validate(@PathVariable String code) {
		Response response = new Response();
		response.setData(repo.existsById(code));
		return response;
	}

	@PostMapping(value = "/edit", consumes = { "application/json" })
	public Response editBook(@RequestBody Book book) {
		repo.deleteById(book.getBookCode());
		repo.save(book);
		Response response = new Response();
		response.setData(book);
		return response;
	}

	@DeleteMapping(value = "/{code}")
	public Response delete(@PathVariable String code) {
		System.out.println("DELETEINGG --------"+code+"----");
		
		repo.deleteById(code);
		
		Response response = new Response();
		response.setData(code);
		return response;
	}

}
