package com.nagarro.advJava1.functionality;

import java.util.*;

import com.nagarro.advJava1.model.Tshirt;

public class Model {

	static ArrayList<Tshirt> tees = new ArrayList<Tshirt>();
	static ArrayList<Tshirt> matchT = new ArrayList<Tshirt>();

	public static void mergeTees(List<Tshirt> list) {
		tees.addAll(list);
	}

	public static void displayTees(List<Tshirt> list) {
		if (list.isEmpty()) {
			System.out.println("NO AVAILABLE TSHIRTS");
			return;
		}
		for (Tshirt t : list) {
			t.printDetails();
		}
	}

	public static void findTshirts(String colour, String size, String gender, String pref) {

		for (Tshirt t : tees) {
			if (t.getAvailability().equals("n")) {
				continue;
			}
			if (t.getColour().equals(colour) && t.getSize().equals(size) && t.getGender().equals(gender)) {
				matchT.add(t);
			}
		}
		if (pref.equals("p")) {
			Collections.sort(matchT, (i, j) -> i.getPrice() > j.getPrice() ? 1 : -1);
		} else if (pref.equals("r")) {
			Collections.sort(matchT, (i, j) -> i.getRating() > j.getRating() ? -1 : 1);
		} else {
			Collections.sort(matchT, (i, j) -> i.getRating() > j.getRating() ? -1 : 1);
			Collections.sort(matchT, (i, j) -> i.getPrice() > j.getPrice() ? 1 : -1);
		}
		displayTees(matchT);
	}

}
