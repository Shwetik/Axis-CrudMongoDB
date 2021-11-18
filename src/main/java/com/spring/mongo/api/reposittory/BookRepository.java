package com.spring.mongo.api.reposittory;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.spring.mongo.api.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>
{
	List<Book> findBookByCategory(String category);
}
