package com.nagarro.advanceJava5.model;

public class Book {

	String bookCode;
	String bookName;
	Author author;
	String addedOn;

	public Book() {
	}

	public Book(String bookCode, String bookName, Author author, String addedOn) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
		this.addedOn = addedOn;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", bookName=" + bookName + ", author=" + author + ", addedOn=" + addedOn
				+ "]";
	}
}
