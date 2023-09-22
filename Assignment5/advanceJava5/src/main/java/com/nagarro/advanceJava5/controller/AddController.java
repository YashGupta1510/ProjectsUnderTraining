package com.nagarro.advanceJava5.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.advanceJava5.model.Author;
import com.nagarro.advanceJava5.model.Book;
import com.nagarro.advanceJava5.service.AuthorService;
import com.nagarro.advanceJava5.service.BookService;

@Controller
public class AddController {

	@Autowired
	BookService bookService;

	@Autowired
	AuthorService authorService;

	@PostMapping(value = "/Add")
	public ModelAndView add() throws IOException, ParseException {
		System.out.println("--------------- IN ADD Controller ----------------");
		ModelAndView mv = new ModelAndView();

		List<Author> authors = authorService.getAllAuthors();
		mv.addObject("authors", authors);
		mv.setViewName("add");

		return mv;
	}

	@PostMapping(value = "/addBook")
	public ModelAndView addBook(HttpServletRequest request) throws IOException, ParseException {

		System.out.println("--------------- IN ADD BOOK ----------------");

		String bookCode = request.getParameter("bookCode");

		ModelAndView mv = new ModelAndView();

		if (bookService.exists(bookCode)) {
			List<Author> authors = authorService.getAllAuthors();
			mv.addObject("authors", authors);
			mv.setViewName("add");
			return mv;
		}

		String bookName = request.getParameter("bookName");
		Author author = new Author(request.getParameter("author"));
		String addedOn = request.getParameter("addedOn");
		Book newBook = new Book();
		newBook.setAddedOn(addedOn);
		newBook.setAuthor(author);
		newBook.setBookCode(bookCode);
		newBook.setBookName(bookName);

		bookService.addBook(newBook);

		List<Book> books = bookService.getAllBooks();
		mv.addObject("books", books);
		mv.setViewName("bookList");
		return mv;
	}
}
