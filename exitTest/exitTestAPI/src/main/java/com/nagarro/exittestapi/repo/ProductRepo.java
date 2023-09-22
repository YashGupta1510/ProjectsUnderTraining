package com.nagarro.exittestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.exittestapi.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

}
