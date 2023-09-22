/*
 *Class name -  Car
 * 
 * version 1.0.0
 * 
 * <copyright>
 * 
 * Author- Yash Gupta
 * 
 * Creation date - 07/03/23
 * 
 * Last updated by - Yash Gupta
 * 
 * Last Updated date - 09/03/23
 * 
 * Description - This is the Car class, it contains the structure of the CAR entity. 
 * 						This program was written for the submission of Assignment 1 of core java.
 */

package classes;

public class Car { 
	private String model;
	private String type;
	private String insuranceType;
	private double price;
	private double premium;

	public Car(String model, String type, String insuranceType, double price) {
		super();
		this.model = model;
		this.type = type;
		this.insuranceType = insuranceType;
		this.price = price;
	}

	public Car(){

	}

	//Getters & Setters
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

}
