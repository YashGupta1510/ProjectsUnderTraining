package com.nagarro.springMVC1.util.tshirts;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.springMVC1.model.Tshirt;
import com.nagarro.springMVC1.util.hibernate.HibernateUtil;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ResourceReader {

	public static void readFiles() {
		System.out.println("----------[ResourceReader]---------");

		final ArrayList<File> fileList = new ArrayList<File>();
		
		final File files = new File("C:\\Users\\yashgupta02\\eclipse-workspace\\springMVC1\\src\\main\\resources\\csv\\");
		
		SessionFactory sessionFactory = HibernateUtil.getTshirtSessionFactory();

		final Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		
		if (files.list() == null) {
			System.out.println("-------No files found-------");
			return;
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
					synchronized (session) {
						runThread(fileList.get(t), session);
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
	}

	static void runThread(File csv, Session session) {
		try {
			CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
			CSVReader reader = new CSVReaderBuilder(new FileReader(csv)).withSkipLines(1).withCSVParser(parser).build();
			List<String[]> file = reader.readAll();
			for (String[] line : file) {
				Tshirt t = createTshirt(line);
				session.saveOrUpdate(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static Tshirt createTshirt(String[] line) {
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
