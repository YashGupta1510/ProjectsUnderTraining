package com.nagarro.notesappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.notesappapi.model.Response;
import com.nagarro.notesappapi.model.Note;
import com.nagarro.notesappapi.service.NotesService;

@RestController
@RequestMapping(value = "/notes")
public class NotesController {

	@Autowired
	NotesService service;

	@GetMapping(path = "/{id}")
	Response getNote(@PathVariable String id) {
		return service.getNote(id);
	}
	
	@DeleteMapping(path = "/{id}")
	Response delNote(@PathVariable String id) {
		return service.delNote(id);
	}
	
	
	@GetMapping(path = "/by/{id}")
	Response getNotesBy(@PathVariable String id) {
		return service.getNotesByUser(id);
	}


	@PostMapping(path = "/create")
	Response create(@RequestBody Note note) {
		return service.create(note);
	}

}


