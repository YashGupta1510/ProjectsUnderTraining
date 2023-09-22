package com.nagarro.notesappapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nagarro.notesappapi.model.Note;
import com.nagarro.notesappapi.model.Response;
import com.nagarro.notesappapi.model.User;
import com.nagarro.notesappapi.repo.NotesRepo;
import com.nagarro.notesappapi.repo.UserRepo;

@Repository
public class NotesService {
	@Autowired
	NotesRepo repo;
	@Autowired
	UserRepo userRepo;
	
	@GetMapping(path = "/{id}")
	public Response getNote(@PathVariable String id) {
		Response response = new Response(repo.findById(id));
		return response;
	}
	
	@DeleteMapping(path = "/{id}")
	public Response delNote(@PathVariable String id) {repo.deleteById(id);
		Response response = new Response("Success");
		return response;
	}
	
	
	@GetMapping(path = "/by/{id}")
	public Response getNotesByUser(@PathVariable String id) {
		List<Note> notes = repo.findFirst10NotesByUserEmailOrderByCreatedAtDesc(id);
		Response response = new Response(notes);
		return response;
	}
	
	@Scheduled(cron = "0 0 * * * *")
	public void cronJob() {
		List<String> uids = new ArrayList<String>();
		List<User> users = userRepo.findAll();
		users.forEach(user -> uids.add(user.getEmail()));
		List<Note> toBeDeleted = repo.findAll();
		List<String> toDel = new ArrayList<String>();
		toBeDeleted.forEach(n ->toDel.add(n.getId()));
		List<String> toKeep = new ArrayList<String>();
		System.out.println(toBeDeleted.size());
		for(String email : uids) {
			List<Note> notes = repo.findFirst10NotesByUserEmailOrderByCreatedAtDesc(email);
			notes.forEach(n -> toKeep.add(n.getId()));
			toDel.removeAll(toKeep);
		}
		repo.deleteAllById(toDel);
	}
	
	
	
	
	@PostMapping(path = "/create")
	public Response create(@RequestBody Note note) {
		System.out.println(note);
		Response response = new Response();
		if (note == null) {
			response.setMessage("Data is Null");
		} else {
			System.out.println(note);
			repo.save(note);
			response.setData(note);
			response.setMessage("note created");
			response.setSuccess(true);
		}
		return response;
	}

}
