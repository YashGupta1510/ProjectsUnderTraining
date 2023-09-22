package com.nagarro.advanceJava5.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.nagarro.advanceJava5.model.Author;
import com.nagarro.advanceJava5.model.Book;

@Component
public class BookService {

	private final String ENDPOINT = "http://localhost:8084/books";

	public void editBook(Book updatedBook) throws IOException {
		URL url = new URL(ENDPOINT+"/edit");
		String json = "{\"bookCode\":\"" + updatedBook.getBookCode() + "\",\"bookName\":\"" + updatedBook.getBookName()
				+ "\",\"author\":\"" + updatedBook.getAuthor().getName() + "\",\"addedOn\":\"" + updatedBook.getAddedOn() + "\"}";

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		System.out.println(json);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.connect();

		byte[] out = json.getBytes(StandardCharsets.UTF_16);

		OutputStream stream = connection.getOutputStream();
		stream.write(out);

		System.out.println(connection.getResponseCode() + " edit book " + connection.getResponseMessage());
		connection.disconnect();

	}

	public void addBook(Book newBook) throws IOException {
		System.out.println("---------- adding book from API /books POST---------");
				
		URL url = new URL(ENDPOINT);
		String json = "{\"bookCode\":\"" + newBook.getBookCode() + "\",\"bookName\":\"" + newBook.getBookName()
				+ "\",\"author\":\"" + newBook.getAuthor().getName() + "\",\"addedOn\":\"" + newBook.getAddedOn() + "\"}";

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.connect();

		byte[] out = json.getBytes(StandardCharsets.UTF_16);

		OutputStream stream = connection.getOutputStream();
		stream.write(out);
		
		System.out.println(connection.getResponseCode() + " addbook " + connection.getResponseMessage());
		connection.disconnect();

	}
	public void deleteBook(String bookCode) throws IOException {
		System.out.println("---------- deleting book from API /books/{code}--"+bookCode+"-------");
		URL url = new URL(ENDPOINT + "/" + bookCode);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("DELETE");

		connection.connect();
		System.out.println(connection.getResponseCode() + "  delete " + connection.getResponseMessage());
		connection.disconnect();
	}

	public List<Book> getAllBooks() throws ParseException, IOException {
		System.out.println("---------- Reading Data from API /books---------");

		URL url = new URL(ENDPOINT);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("GET");

		connection.connect();

		int rc = connection.getResponseCode();
		String responseBody = "";
		if (rc != 200) {
			return new ArrayList<Book>();
		}
		Scanner ob = new Scanner(connection.getInputStream());
		while (ob.hasNext()) {
			responseBody += ob.nextLine();
		}
		ob.close();
		JSONParser parser = new JSONParser();

		JSONObject obj = (JSONObject) parser.parse(responseBody);
		connection.disconnect();

		List<Book> books = new ArrayList<Book>();

		List<Map<String, Object>> data = (List<Map<String, Object>>) obj.get("data");
		for (Map<String, Object> map : data) {

			Book t = new Book();
			t.setBookCode((String) map.get("bookCode"));
			t.setBookName((String) map.get("bookName"));
			t.setAddedOn((String) map.get("addedOn"));
			t.setAuthor(new Author(((Map<String, String>) map.get("author")).get("name")));
			System.out.println( t.getAuthor()+ " name");
			books.add(t);
			
		}

		return books;
	}

	public boolean exists(String bookCode) throws IOException, ParseException {
		URL url = new URL(ENDPOINT + "/" + bookCode);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("GET");

		connection.connect();
		

		int rc = connection.getResponseCode();
		String responseBody = "";
		
		Scanner ob = new Scanner(connection.getInputStream());
		while (ob.hasNext()) {
			responseBody += ob.nextLine();
		}
		ob.close();
		connection.disconnect();
		
		JSONParser parser = new JSONParser();
	
		JSONObject obj = (JSONObject) parser.parse(responseBody);
	
		
		boolean data = (Boolean) obj.get("data");
	
		
		System.out.println(connection.getResponseCode() + " exist method " + connection.getResponseMessage());
		connection.disconnect();
		return data;
	}

}
