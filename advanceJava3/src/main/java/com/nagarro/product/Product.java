package com.nagarro.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity(name = "Product")
public class Product {

	@Id
	private String title;

	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "size")
	private int size;
	
	@Column(name = "image")
	@Type(type="org.hibernate.type.ImageType")
	private byte[] image;
	
	@Column(name = "uname")
	private String uname;
	private int imagesize;
	
	
	
	
	public Product() {
		System.out.println("Welcome to class");

	}


	public int getImagesize() {
		return imagesize;
	}

	public void setImagesize(int imagesize) {
		this.imagesize = imagesize;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

}