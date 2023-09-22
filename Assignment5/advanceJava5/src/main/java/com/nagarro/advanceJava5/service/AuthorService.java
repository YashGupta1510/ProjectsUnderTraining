package com.nagarro.advanceJava5.service;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;


import com.nagarro.advanceJava5.model.Author;


@Component
public class AuthorService {

	private final String ENDPOINT = "http://localhost:8084/authors";

	public List<Author> getAllAuthors() throws IOException, ParseException {
		System.out.println("---------- Reading Data from API /authors---------");

		URL url = new URL(ENDPOINT);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("GET");

		connection.connect();

		int rc = connection.getResponseCode();
		String responseBody = "";
		if (rc != 200) {
			return new ArrayList<Author>();
		}
		Scanner ob = new Scanner(connection.getInputStream());
		while (ob.hasNext()) {
			responseBody += ob.nextLine();
		}
		ob.close();
		
		JSONParser parser = new JSONParser();
	
		JSONObject obj = (JSONObject) parser.parse(responseBody);
		connection.disconnect();
		
		List<Author> authors = new ArrayList<Author>();
		
		List<Map<String,String>> data =( List<Map<String,String>> )obj.get("data");
		for(Map<String,String> map : data) {
			String name = map.get("name");
			authors.add(new Author(name));
		}
		
		return authors;
	}

}
