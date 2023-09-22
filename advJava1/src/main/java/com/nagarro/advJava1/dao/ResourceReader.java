package com.nagarro.advJava1.dao;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.advJava1.functionality.Model;
import com.nagarro.advJava1.model.Tshirt;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ResourceReader {

	public void readFiles() {
		ArrayList<File> fileList = new ArrayList<File>();

		final File files = new File("classes\\");
		
		for (final File file : files.listFiles()) {
			if (file.getName().contains(".csv"))
				fileList.add(file);

		}
		int nThreads = fileList.size();
		Thread thread[] = new Thread[nThreads];

		for (int i = 0; i < nThreads; i++) {
			final int t = i;
			thread[t] = new Thread() {
				@Override
				public void run() {
					runThread(fileList.get(t));
				}
			};
		}
		for (Thread t1 : thread) {
			t1.start();
		}
		for (Thread t2 : thread) {
			try {
				t2.join();
			} catch (InterruptedException e) {
				System.out.println("__________ERROR OCCURED WHILE MERGING THREADS_________");
				e.printStackTrace();
			}
		}

	}

	void runThread(File csv) {
		List<Tshirt> list = new ArrayList<Tshirt>();
		try {
			CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
			CSVReader reader = new CSVReaderBuilder(new FileReader(csv)).withSkipLines(1).withCSVParser(parser).build();
			List<String[]> file = reader.readAll();
			for (String[] line : file) {
				Tshirt t = createTshirt(line);
				list.add(t);
			}
			Model.mergeTees(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	Tshirt createTshirt(String[] line) {
		Tshirt tee = new Tshirt();
		tee.setID(line[0].toLowerCase());
		tee.setName(line[1].toLowerCase());
		tee.setColour(line[2].toLowerCase());
		tee.setGender(line[3].toLowerCase());
		tee.setSize(line[4].toLowerCase());
		tee.setPrice(Float.parseFloat(line[5]));
		tee.setRating(Float.parseFloat(line[6]));
		tee.setAvailability(line[7].toLowerCase());
		return tee;
	}

}
