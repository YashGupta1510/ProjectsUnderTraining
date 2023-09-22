package com.nagarro.advanceJava5.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.advanceJava5.model.Book;
import com.nagarro.advanceJava5.service.BookService;

@Controller
public class DeleteController {

	@Autowired
	BookService bookService;
	
	@PostMapping(value = "/delete")
	public ModelAndView delete(HttpServletRequest request) throws IOException, ParseException {
		ModelAndView mv = new ModelAndView();
		String bookCode = request.getParameter("bookCode");
		bookService.deleteBook(bookCode.trim());
		
		List<Book> books = bookService.getAllBooks();
		mv.addObject("books", books);
		mv.setViewName("bookList");
	
		return mv;
	}
}
