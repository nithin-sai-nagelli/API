package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class BookController {
	private final BookRepository bookRepository;
	private final BookService bookService;
	
	public BookController(BookRepository bookRepository,BookService bookService) {
		this.bookRepository= bookRepository;
		this.bookService= bookService;
	}
	
	@GetMapping("/api/books")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@PostMapping("/api/books")
	public ResponseEntity<?> addBook(@RequestBody Book book) {
		if (bookService.existsById(book.getId())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Book with id " + book.getId() + " already exists.");
        }
        bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }
	
	
	@PutMapping("/api/books/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book newBook) {
		Optional<Book> optionalExistingBook = bookRepository.findById(id);

        if (optionalExistingBook.isPresent()) {
            Book book = optionalExistingBook.get();
            book.setName(newBook.getName());
            book.setAuthor(newBook.getAuthor());
            book.setYear(newBook.getYear());
            bookRepository.save(book);
            return book;
        }
        else {
        	throw new NoSuchElementException("Book with ID " + newBook.getId() + " not found");
        }
	}
	
	
}
