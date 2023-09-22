package com.nagarro.notesappapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.notesappapi.model.Note;

@Repository
public interface NotesRepo extends JpaRepository<Note, String>{

	List<Note> findFirst10NotesByUserEmailOrderByCreatedAtDesc(String id);
	
	List<Note> findNotesByUserEmail(String email);

}


