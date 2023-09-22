package com.nagarro.exittestapi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.exittestapi.model.Response;
import com.nagarro.exittestapi.model.User;
import com.nagarro.exittestapi.repo.UserRepo;
import com.nagarro.exittestapi.service.UserService;

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

	@GetMapping(path = "/count")
	Response count() {
		return service.count();
	}

}
