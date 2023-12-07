package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Book {
	@Id
	@NotNull(message = "Id cannot be null")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Author cannot be blank")
    private String author;

    @NotNull(message = "Year cannot be null")
    private Long pubyear;
	
	public Book() {
	}

	public Book(Long id, String name, String author, Long year) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.pubyear = year;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getYear() {
		return pubyear;
	}
	public void setYear(Long year) {
		this.pubyear = year;
	}
	
}
