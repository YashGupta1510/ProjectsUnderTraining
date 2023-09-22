<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.nagarro.product.Product"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%

	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
try{
	
	if (session.getAttribute("username") == null) {
		response.sendRedirect("Login.jsp");
		return;
	}

	String title = request.getParameter("title");
	
	SessionFactory factory = new Configuration().configure("hibernate2.cfg.xml")
			.addAnnotatedClass(Product.class).buildSessionFactory();
	//Opening Session
	Session session2 = factory.openSession();
	
	session2.beginTransaction();
	
	Query query = session2.createQuery("from Product where title=:title");
	query.setParameter("title", title);
	
	//Will give unique result for the respective Title
	Product product = (Product) query.uniqueResult();

	byte[] img = product.getImage();
;
	response.setContentType("image/jgp");
    OutputStream os = response.getOutputStream();
	os.write(img);
	os.flush();
	os.close();	
	//session2.close();
	
}catch(Exception e){
	System.out.println("Exception Occur"+e.getMessage());

}

%>