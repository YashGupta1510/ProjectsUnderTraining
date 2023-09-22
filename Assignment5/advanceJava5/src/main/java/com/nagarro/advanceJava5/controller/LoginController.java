package com.nagarro.advanceJava5.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.advanceJava5.model.Author;
import com.nagarro.advanceJava5.model.Book;
import com.nagarro.advanceJava5.service.BookService;
import com.nagarro.advanceJava5.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	BookService bookService;

	@PostMapping(value = "/Login")
	public ModelAndView login(HttpServletRequest request) throws IOException, ParseException {
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");

		System.out.println(username + "----" + password);

		ModelAndView mv = new ModelAndView();
		boolean isValid = loginService.checkUser(username, password);
		if (isValid) {
			List<Book> books = bookService.getAllBooks();
			mv.addObject("username", username);
			mv.addObject("books", books);
			System.out.println("------- Login Complete Moving to BookList Screen --------");
			mv.setViewName("bookList");
		} else {
			mv.setViewName("login");
		}
		return mv;
	}

	@PostMapping(value = "/Logout")
	public ModelAndView logout() {
		return new ModelAndView("login");
	}
	
	
}
