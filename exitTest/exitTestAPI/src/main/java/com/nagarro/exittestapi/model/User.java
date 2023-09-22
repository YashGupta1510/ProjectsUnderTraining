package com.nagarro.exittestapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

	private String fname;
	private String lname;

	@Id
	private String email;
	private String password;
	private boolean isAdmin;

	User() {
	}

	public User(String fname, String lname, String email, String password, boolean isAdmin) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", email=" + email + ", password=" + password
				+ ", isAdmin=" + isAdmin + "]";
	}

}
