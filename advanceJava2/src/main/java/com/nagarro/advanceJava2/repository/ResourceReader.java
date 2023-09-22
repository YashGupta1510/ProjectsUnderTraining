package com.nagarro.advanceJava2.repository;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import com.nagarro.advanceJava2.model.Tshirt;

public class ResourceReader {

	public void readFiles() {
		ArrayList<File> fileList = new ArrayList<File>();

		final File files = new File("src\\main\\resources\\");

		HibernateUtil hUtil = new HibernateUtil();

		Transaction tx = hUtil.session.beginTransaction();
		if (files.list() == null) {
			System.out.println("No files found");
			System.exit(0);
		}
		for (final File file : files.listFiles()) {
			if (file.getName().contains(".csv")) {
				fileList.add(file);
			}

		}
		int nThreads = fileList.size();
		Thread thread[] = new Thread[nThreads];

		for (int i = 0; i < nThreads; i++) {
			final int t = i;
			thread[t] = new Thread() {
				@Override
				public void run() {
					synchronized (hUtil.session) {
						runThread(fileList.get(t), hUtil.session);
					}
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

		tx.commit();

		hUtil.session.close();

	}

	void runThread(File csv, Session session) {
		try {
			CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
			CSVReader reader = new CSVReaderBuilder(new FileReader(csv)).withSkipLines(1).withCSVParser(parser).build();
			List<String[]> file = reader.readAll();
			for (String[] line : file) {
				Tshirt t = createTshirt(line);

				session.persist(t);
			}
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
