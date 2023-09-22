package com.nagarro.advanceJava5API.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.advanceJava5API.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, String> {

}
