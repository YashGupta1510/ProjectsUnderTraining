package com.nagarro.exittestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.exittestapi.model.Response;
import com.nagarro.exittestapi.model.Review;
import com.nagarro.exittestapi.repo.ProductRepo;
import com.nagarro.exittestapi.repo.ReviewRepo;

@Repository
public class ReviewService {

	@Autowired
	ReviewRepo repo;

	@Autowired
	ProductRepo pRepo;

	public Response getReviews(String code) {

		Response response = new Response();
		response.setData(repo.findByCode(code));
		response.setMessage("Success");
		response.setSuccess(true);

		return response;
	}

	public Response getAllReviews() {

		Response response = new Response();
		response.setData(repo.findAll());
		response.setMessage("Success");
		response.setSuccess(true);

		return response;
	}

	public Response approveReview(String id) {
		Response response = new Response();
		Review r = repo.findById(id).get();
		r.setApproved(true);
		repo.deleteById(id);
		repo.save(r);
		response.setData(r);
		response.setMessage("Approved");
		response.setSuccess(true);

		return response;

	}

	public Response deleteReview(String id) {
		Response response = new Response();
		Review r = repo.findById(id).get();
		repo.deleteById(id);
		response.setData(r);
		response.setMessage("Deleted");
		response.setSuccess(true);

		return response;

	}

	public Response createReview(Review review) {
		Response response = new Response();
		repo.save(review);
		response.setMessage("Success");
		response.setSuccess(true);
		response.setData(review);
		return response;
	}

	public Response count() {
		return new Response(repo.countByApproved(true));
	}

}
