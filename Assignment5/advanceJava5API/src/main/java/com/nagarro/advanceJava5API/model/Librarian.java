package com.nagarro.advanceJava5API.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Librarian {
	@Id
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Librarian [username=" + username + ", password=" + password + "]";
	}
}
