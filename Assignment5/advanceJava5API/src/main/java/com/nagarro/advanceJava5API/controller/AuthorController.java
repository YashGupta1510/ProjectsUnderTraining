package com.nagarro.advanceJava5API.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.advanceJava5API.Repo.AuthorRepo;
import com.nagarro.advanceJava5API.model.Response;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

	@Autowired
	AuthorRepo repo;
	
	@GetMapping
	public Response getAuthors(){
		Response response = new Response();
		response.setData(repo.findAll());
		return response;
	}
	
}
