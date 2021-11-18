package com.spring.mongo.api.service;

import java.util.List;

import com.spring.mongo.api.model.Book;

public interface BookService {
	void addBook(Book book);
	List<Book> getAllBooks();
	Book getBookById(int id);
	void deleteBook(int id);
	List<Book> getBookByCategory(String category);
}
