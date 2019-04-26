package com.practice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.bean.Book;

@RestController
public class BookController {

	@Autowired
	BookDao bookDao;

	@GetMapping("/books")
	public List<Book> getBooks() {
		List<Book> books = new ArrayList<>();

		books.add(new Book(1, "Clean Code", "Robert C Martin"));

		return books;
	}

	@GetMapping("/book")
	public Book getBookById(@RequestParam Long id) {
		return bookDao.getBook(id);
	}

	@PostMapping("/book")
	public void addBook(@RequestBody Book book) {
		System.out.println("Creating Book..");
		bookDao.saveBook(book);
	}

}
