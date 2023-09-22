package com.nagarro.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Users")
public class Users {
	@Id
	String uname;
	 @Column(name="pass")
	String pass;
	
	 public Users(){}
	@Override
	public String toString() {
		return "Users [uname=" + uname + ", pass=" + pass + "]";
	}
	public Users(String uname, String pass) {
		
		this.uname = uname;
		this.pass = pass;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
	       