package com.nagarro.product;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

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
import org.hibernate.query.Query;

@MultipartConfig
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
			HttpSession sessionHttp = request.getSession();
			String uname = (String) sessionHttp.getAttribute("username");
			String title = request.getParameter("title");

			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int size = Integer.parseInt(request.getParameter("size"));

			boolean flag = true;
			Part file = request.getPart("image");
			int imagesize = (int) file.getSize();
			System.out.println("The size of the image is" + imagesize);

			byte[] data = null;

			if (imagesize == 0) {
			//	System.out.println("New image is not uploaded");
				flag = false;
			} else {
				String imageFileName = file.getSubmittedFileName(); // get selected image file name

				String uploadPath = "C:\\Users\\yashgupta02\\eclipse-workspace\\advanceJava3\\src\\main\\webapp\\images\\"
						+ imageFileName;
				
					FileOutputStream fos = new FileOutputStream(uploadPath);
					InputStream is = file.getInputStream();

					data = new byte[is.available()];
					is.read(data);
					fos.write(data);
					is.close();
					fos.flush();
					fos.close();
				
				SessionFactory factory1 = new Configuration().configure("hibernate2.cfg.xml")
						.addAnnotatedClass(Product.class).buildSessionFactory();
				Session session3 = factory1.openSession();
				session3.beginTransaction();

				Query query2 = session3.createQuery("from Product where uname=:username");
				query2.setParameter("username", uname);
				List<Product> products = query2.list();
				
				
				int totalSize = 0;
				for (Product product : products) {
					totalSize = totalSize + product.getImagesize();
				}
				if (totalSize != 0) {

					long finalSize = totalSize + imagesize;
					System.out.println("The final size is " + finalSize);
					
					//to check if image size is more than specified limit of all products 
					if (finalSize > 1 * 1024 * 1024) {
						session3.getTransaction().commit();
						session3.close();
						response.sendRedirect("index.jsp");
						return;
					}

					session3.getTransaction().commit();
					session3.close();
				}
			}

			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
					.buildSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();

		
			if (flag) {
				System.out.println("image is edited");
				String hql = "update Product set quantity=:qtity,size=:si,image=:img,imagesize=:imgs where title=:tle";
				Query searchQuery = session.createQuery(hql);

				searchQuery.setParameter("qtity", quantity);
				searchQuery.setParameter("si", size);
				searchQuery.setParameter("img", data);
				searchQuery.setParameter("tle", title);
				searchQuery.setParameter("imgs", imagesize);

				System.out.println("Image size is" + imagesize);

				searchQuery.executeUpdate();
				System.out.println("New Image is uploaded ");
			}
			// IF NO IMAGE UPLOADED THEN
			else {
				System.out.println("text is edited");
				Query searchQuery = session
						.createQuery("update Product set quantity=:quantity,size=:size where title=:title");
				searchQuery.setParameter("quantity", quantity);
				searchQuery.setParameter("size", size);
				searchQuery.setParameter("title", title);
				searchQuery.executeUpdate();
			}
			session.getTransaction().commit();
			session.close();

		response.sendRedirect("index.jsp");
	}

}