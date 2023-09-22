package com.nagarro.exittestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.exittestapi.model.Response;
import com.nagarro.exittestapi.model.Review;
import com.nagarro.exittestapi.service.ReviewService;

@RestController
@RequestMapping(path = "/reviews")
public class ReviewController {

	@Autowired
	ReviewService service;

	@GetMapping(path = "/{code}")
	Response getReviews(@PathVariable String code) {
		return service.getReviews(code);
	}

	@GetMapping(path = "/")
	Response getAllReviews() {
		return service.getAllReviews();
	}

	@GetMapping(path = "/approve/{id}")
	Response approveReview(@PathVariable String id) {

		return service.approveReview(id);

	}

	@GetMapping(path = "/delete/{id}")
	Response deleteReview(@PathVariable String id) {

		return service.deleteReview(id);

	}

	@PostMapping(path = "/create")
	Response createReview(@RequestBody Review review) {

		return service.createReview(review);
	}

	@GetMapping(path = "/count")
	Response count() {

		return service.count();
	}

}
