package com.nagarro.product;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



@WebServlet("/upload")
@MultipartConfig
public class SaveProducts extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession sessionHttp = request.getSession();
			
			String uname = (String) sessionHttp.getAttribute("username");

			String title = request.getParameter("title");

			int quantity = Integer.parseInt(request.getParameter("quantity"));

			int size = Integer.parseInt(request.getParameter("size"));
			
			//to get the passed image
			Part imagePart = request.getPart("image");
			int imagesize = (int) imagePart.getSize();
			
			
			String imageFileName = imagePart.getSubmittedFileName(); // get selected image file name
			System.out.println("----------SAVING FILE----------");
			String uploadPath = "C:\\Users\\yashgupta02\\eclipse-workspace\\advanceJava3\\src\\main\\webapp\\images\\"
					+ imageFileName; 

			byte[] data;
			// FOR STORING IMAGE
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = imagePart.getInputStream();

			data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			is.close();
			fos.close();
			
			Product newProduct = new Product();
			// ADDING PRODUCT
					
			
			newProduct.setImage(data);
			newProduct.setQuantity(quantity);
			newProduct.setSize(size);
			newProduct.setTitle(title);
			newProduct.setUname(uname);
			newProduct.setImagesize(imagesize);
			
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
					.buildSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();

			session.saveOrUpdate(newProduct);
			session.getTransaction().commit();
			System.out.println(session.getTransaction().getStatus());
			session.close();
			response.sendRedirect("index.jsp");

		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
