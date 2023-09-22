package com.nagarro.exittestapi.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Product {
	private String name;

	@Id
	private String code;
	private String brand;
	private double avgRating;


	public Product(String name, String code, String brand, double avgRating) {
		super();
		this.name = name;
		this.code = code;
		this.avgRating = avgRating;
		this.brand = brand;
		
	}

	public Product() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	


	@Override
	public String toString() {
		return "Product [name=" + name + ", code=" + code + ", brand=" + brand +"]";
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

}
