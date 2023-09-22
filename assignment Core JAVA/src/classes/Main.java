/*
 *Class name -  Main
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
 * Description - This is the main class, it contains the main logic of the program. 
 * 						This program was written for the submission of Assignment 1 of core java.
 */


package classes;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	static ArrayList<Car> list = new ArrayList<Car>();

	static double calculatePremium(Car car) {

		//This method is returns the final premium payable by the client

		String type = car.getType();
		String insuranceType = car.getInsuranceType();
		double price = car.getPrice();
		double base = 0.0;
		double premium = 0.0;

		//Calculating base premium based on type of car 
		if (type.equals("hatchback")) {
			base = price * 0.05;
		} else if (type.equals("sedan")) {
			base = price * 0.08;
		} else {
			base = price * 0.1;
		}

		//Calculating additional premium based on the type of insurance
		if (insuranceType.equals("basic")) {
			premium = base;
		} else {
			premium = base + base * 0.2;
		}

		return premium;
	}

	static void input() {
		Scanner ob = new Scanner(System.in);
		char flag = 'y';
		String model;
		String type;
		String insuranceType;
		double price;

		while (flag == 'y') {

			try {

				model = ob.next();

				type = ob.next().toLowerCase();
				if( (type.equals("hatchback")) || 
						(type.equals("sedan")) || 
						(type.equals("suv")) ) {} else {
							throw new InputException("Invalid Car Type : "
									+ "Available Car type are Hatchback, Sedan, SUV");
						}

				price = ob.nextDouble();
				if(price < 0.0){
					throw new InputException("Invalid Price : Price can't be negative");
				}


				insuranceType = ob.next().toLowerCase();
				if( (insuranceType.equals("basic")) || 
						(insuranceType.equals("premium")) ) {} else {
							throw new InputException("Invalid Insurance Type : "
									+ "Available Insurance Types are Basic and Premium");
						}

				//Creating a new car instance
				Car car = new Car(model, type, insuranceType, price);

				//Adding new car in the list
				list.add(car);

			} catch (InputException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("--INVALID INPUT--");
			}

			System.out.println("Do you want to enter details of any other car (y/n):");
			flag = ob.next().toLowerCase().charAt(0);
		}
	}
	

	static void display(Car car) {
		System.out.println("Car Model : " + car.getModel());
		System.out.println("Cost Price : " + car.getPrice() +" ₹");
		System.out.println("Total Premium Payable : " + calculatePremium(car) +" ₹");
		System.out.println();
	}

	public static void main(String[] args) {
		input();
		for (Car c : list) {
			display(c);
		}
	}
}
