package com.nagarro.advanceJava5.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.advanceJava5.model.Book;
import com.nagarro.advanceJava5.service.BookService;

@Controller
public class HomeController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}
	
	@RequestMapping(value= "/home")
	public ModelAndView home() throws ParseException, IOException {
		ModelAndView mv = new ModelAndView("bookList");
		List<Book> books = bookService.getAllBooks();
		mv.addObject("books", books);
		return mv;
	}
	
}
