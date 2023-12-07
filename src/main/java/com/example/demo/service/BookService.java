package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {
    private final BookRepository bookRepository;
    
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

	public boolean existsById(Long id) {
		return bookRepository.findById(id).isPresent();
	}
    
}
