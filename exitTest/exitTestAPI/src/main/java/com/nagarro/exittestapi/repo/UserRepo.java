package com.nagarro.exittestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.exittestapi.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

}
