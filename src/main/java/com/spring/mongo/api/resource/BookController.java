package com.spring.mongo.api.resource;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.mongo.api.model.Book;
import com.spring.mongo.api.reposittory.BookRepository;
import com.spring.mongo.api.service.BookServiceImpl;

@RestController
@RequestMapping(value="/book")
public class BookController {
	@Autowired
private BookServiceImpl service;
	@PostMapping(value="/addBook")
	public void addBook(@RequestBody Book book) {
		service.addBook(book);
	}
	
	@GetMapping(value="/getAllBooks")
	public ResponseEntity<List<Book>> getAllBooks(){
		return new ResponseEntity<List<Book>>(service.getAllBooks(),HttpStatus.OK);
	}
	
	@GetMapping(value="/getBookById/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id){
		//throw an exception if id not found
		return new ResponseEntity<Book>(service.getBookById(id),HttpStatus.OK);
	}
	@DeleteMapping(value="/deleteBook/{id}")
	public void deleteProduct(@PathVariable int id) {
		//throw an exception if id not found
		service.deleteBook(id);
	}
	@PutMapping(value="/updateBook/{id}")
	public ResponseEntity<Book> updateProduct(@RequestBody Book book,@PathVariable int id){
		Book p=service.getBookById(id);//throw an exception if id not found
		service.addBook(book);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	//===================Find product by Category======================
	@GetMapping(value="/getBookByCategory/{category}")
	public ResponseEntity<List<Book>> getBookByCategory(@PathVariable String category){
		return new ResponseEntity<List<Book>>(service.getBookByCategory(category),HttpStatus.OK);
	}
}
