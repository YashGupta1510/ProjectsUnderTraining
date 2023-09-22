package com.nagarro.springMVC1.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tshirt {
	
	@Id
	private String id;
	private String name;
	private String colour;
	private String gender;
	private String size;
	private float rating;
	private float price;
	private String availability;

	public Tshirt() {
	}


	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public void printDetails() {
		System.out.print("Name- " + name + "\tColour- " + colour + "\tGender " + gender + "\tPrice "
				+ price + "\tRating- " + rating +"\n");
	}
	
	@Override
	public String toString() {
		return "Tshirt [id=" + id + ", name=" + name + ", colour=" + colour + ", gender=" + gender + ", size=" + size
				+ ", rating=" + rating + ", price=" + price + ", availability=" + availability + "]";
	}

	
}