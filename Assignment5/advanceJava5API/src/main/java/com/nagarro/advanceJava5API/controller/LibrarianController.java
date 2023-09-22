package com.nagarro.advanceJava5API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.advanceJava5API.Repo.LibrarianRepo;

import com.nagarro.advanceJava5API.model.Response;

@RestController
@RequestMapping(value = "/librarians")
public class LibrarianController {
	@Autowired
	LibrarianRepo repo;

	@GetMapping(path = "/{username}")
	public Response checkLibrarian(@PathVariable String username) {
		Response response = new Response();
		response.setData(repo.findById(username));
		return response;
	}

}
