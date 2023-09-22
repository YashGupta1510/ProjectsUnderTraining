package com.nagarro.advanceJava5.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
public class EditController {

	@Autowired
	BookService bookService;

	@Autowired
	AuthorService authorService;

	@PostMapping(value = "/Edit")
	public ModelAndView edit(HttpServletRequest request) throws IOException, ParseException {

		System.out.println("--------------- IN EDIT PAGE ----------------");

		String bookCode = request.getParameter("bookCode");
		String bookName = request.getParameter("bookName");
		String author = request.getParameter("author");
		String addedOn = request.getParameter("addedOn");
		Author at = new Author(author);
		System.out.println(bookCode+" !!!"+ bookName);
		List<Author> _authors = authorService.getAllAuthors();
		ModelAndView mv = new ModelAndView();
		mv.addObject("bookCode", bookCode);
		mv.addObject("bookName", bookName);
		mv.addObject("addedOn", addedOn);
		mv.addObject("author", at);
		mv.addObject("authors", _authors);
		mv.setViewName("edit");
		return mv;
	}

	@PostMapping(value = "/editDetails")
	public ModelAndView editDetails(HttpServletRequest request) throws IOException, ParseException {

		System.out.println("--------------- IN EDIT COMPLETE ----------------");
		ModelAndView mv = new ModelAndView();

		String bookCode = request.getParameter("bookCode");
		String bookName = request.getParameter("bookName");
		String author = request.getParameter("author");
		String addedOn = request.getParameter("addedOn");
		System.out.println(request.getParameter("bookName") + "||||||" + author + "|||||||");
		Book updatedBook = new Book();
		updatedBook.setAddedOn(addedOn);

		Author at = new Author(author);

		updatedBook.setAuthor(at);
		updatedBook.setBookCode(bookCode.trim());
		updatedBook.setBookName(bookName);

		bookService.editBook(updatedBook);

		List<Book> books = bookService.getAllBooks();
		mv.addObject("books", books);
		mv.setViewName("bookList");

		return mv;
	}

}
