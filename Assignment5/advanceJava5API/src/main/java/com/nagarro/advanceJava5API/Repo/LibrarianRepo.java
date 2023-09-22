package com.nagarro.advanceJava5API.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.advanceJava5API.model.Librarian;

@Repository
public interface LibrarianRepo extends JpaRepository<Librarian, String> {

}
