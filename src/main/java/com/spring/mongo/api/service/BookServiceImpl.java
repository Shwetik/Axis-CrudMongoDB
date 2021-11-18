package com.spring.mongo.api.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.mongo.api.model.Book;
import com.spring.mongo.api.reposittory.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository repo;
	@Override
	public void addBook(Book book) {
		repo.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return repo.findAll();
	}

	@Override
	public Book getBookById(int id) throws NoSuchElementException{
		Book p=repo.findById(id).get();
		return p;
	}

	@Override
	public void deleteBook(int id) {
		repo.deleteById(id);
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		return repo.findBookByCategory(category);
	}

}
