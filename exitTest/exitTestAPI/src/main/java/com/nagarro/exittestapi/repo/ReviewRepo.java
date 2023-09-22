package com.nagarro.exittestapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.exittestapi.model.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, String> {

	public List<Review> findByCode(String code);

	public Long countByApproved(boolean approved);

}
