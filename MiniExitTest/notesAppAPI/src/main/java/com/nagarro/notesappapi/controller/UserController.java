package com.nagarro.notesappapi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.notesappapi.model.Response;
import com.nagarro.notesappapi.model.User;
import com.nagarro.notesappapi.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping(path = "/{id}")
	Response getUser(@PathVariable String id) {
		return service.getUser(id);
	}

	@PostMapping(path = "/verify")
	Response verify(@RequestBody Map<String, String> credentials) {
		return service.verify(credentials);
	}

	@PostMapping(path = "/create")
	Response create(@RequestBody User user) {
		return service.create(user);
	}

}


