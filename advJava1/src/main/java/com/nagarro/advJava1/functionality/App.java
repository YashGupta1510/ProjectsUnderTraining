package com.nagarro.advJava1.functionality;

import java.util.*;

import com.nagarro.advJava1.dao.ResourceReader;

/**
 * 
 * Driver class
 *
 */
public class App {
	public static void main(String[] args) {

		Scanner ob = new Scanner(System.in);
		System.out.println("Enter the choice of Colour");
		String colour = ob.nextLine().toLowerCase();
		System.out.println("Enter the preferred size (S/M/L/XL/XXL)");
		String size = ob.nextLine().toLowerCase();
		while(!(size.equals("s") || size.equals("m") ||size.equals("l") ||size.equals("xl") ||size.equals("xxl"))) {
			System.out.println("Enter VALID preferred size (S/M/L/XL/XXL)");
			size = ob.nextLine().toLowerCase();
		}
		
		System.out.println("Enter Gender for which this T-shirt is needed. \nM, F, U (M – Male, F- Female, U-Unisex)");
		String gender = ob.nextLine().toLowerCase();
		
		while(!(gender.equals("f") || gender.equals("m") ||gender.equals("u"))) {
			System.out.println("Enter VALID Gender M/U/F (M – Male, F- Female, U-Unisex)");
			gender = ob.nextLine().toLowerCase();
		}
		ResourceReader resourceReader = new ResourceReader();
		resourceReader.readFiles();

		System.out.println(
				"Enter preferred sorting criteria : \n P for Sorting by Price\n R for Sorting by Rating\n B for Sorting considering both");
		String pref = ob.next().toLowerCase();

		Model.findTshirts(colour, size, gender, pref);

	}
}
