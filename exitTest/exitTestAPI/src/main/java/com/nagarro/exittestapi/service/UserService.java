package com.nagarro.exittestapi.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nagarro.exittestapi.model.Response;
import com.nagarro.exittestapi.model.User;
import com.nagarro.exittestapi.repo.UserRepo;

@Repository
public class UserService {

	@Autowired
	UserRepo repo;

	@GetMapping(path = "/{id}")

	public Response getUser(@PathVariable String id) {
		Response response = new Response(repo.findById(id));
		return response;
	}

	@PostMapping(path = "/verify")
	public Response verify(@RequestBody Map<String, String> credentials) {

		Response response = new Response();

		if (credentials.get("email").isEmpty() || credentials.get("password").isEmpty()) {
			response.setMessage("Empty Credentials");
		} else if (!(repo.existsById(credentials.get("email")))) {
			response.setMessage("User Not Found");
		} else {
			User user = repo.findById(credentials.get("email")).get();
			if (user.getPassword().equals(credentials.get("password"))) {
				response.setData(user);
				response.setMessage("User Verified");
				response.setSuccess(true);
			} else {
				response.setData(null);
				response.setMessage("Inavlid Credentials");
				response.setSuccess(false);
			}
		}

		return response;
	}

	@PostMapping(path = "/create")
	public Response create(@RequestBody User user) {

		System.out.println(user);
		Response response = new Response();
		if (user == null) {
			response.setMessage("Data is Null");
		} else if (repo.existsById(user.getEmail())) {
			response.setData(repo.findById(user.getEmail()));
			response.setMessage("User Already Exists");
		} else {
			System.out.println(user);
			repo.save(user);
			System.out.println(user);
			response.setData(user);
			response.setMessage("User Created");
			response.setSuccess(true);
		}
		return response;
	}

	@GetMapping(path = "/count")
	public Response count() {
		return new Response(repo.count());
	}

}
