package com.nagarro.advanceJava5.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;


@Component
public class LoginService {
	private final String ENDPOINT = "http://localhost:8084/librarians";
	public boolean checkUser(String username, String password) throws IOException, ParseException {
		System.out.println("---------- Reading Data from API /librarian---------");

		URL url = new URL(ENDPOINT+"/"+username);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("GET");

		connection.connect();

		int rc = connection.getResponseCode();
		String responseBody = "";
		
		if (rc != 200) {
			System.out.println("ERRR");
			return false;
		}
		Scanner ob = new Scanner(connection.getInputStream());
		while (ob.hasNext()) {
			responseBody += ob.nextLine();
		}
		ob.close();
		connection.disconnect();
		
		JSONParser parser = new JSONParser();
	
		JSONObject obj = (JSONObject) parser.parse(responseBody);
		
		Map<String,String> data = (Map<String,String>) obj.get("data");
		
		
		return data.get("password").equals(password);
	}
}
