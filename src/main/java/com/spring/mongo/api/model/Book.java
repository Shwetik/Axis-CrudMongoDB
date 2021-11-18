package com.spring.mongo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "book") //replacement for mySQL @Entity
public class Book {
	@Id
private int id;
private String book;
private String category;
private double price;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBook() {
	return book;
}
public void setBook(String book) {
	this.book = book;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

public Book(int id, String book, String category, double price) {
	super();
	this.id = id;
	this.book = book;
	this.category = category;
	this.price = price;
}


}
