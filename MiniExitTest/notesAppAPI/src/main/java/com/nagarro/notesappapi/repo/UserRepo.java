package com.nagarro.notesappapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.notesappapi.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

}

