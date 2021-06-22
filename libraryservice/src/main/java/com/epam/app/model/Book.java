package com.epam.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Book {
	
	private int id;
	private String  title;
	private String author;
	private String category;
	private String publisher;
	
	public Book(String title, String author, String category, String publisher) {
		this.title = title;
		this.author = author;
		this.category = category;
		this.publisher = publisher;
	}
	
	

}
