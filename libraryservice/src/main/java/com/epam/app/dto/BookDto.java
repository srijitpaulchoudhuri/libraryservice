package com.epam.app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {

	private String  title;
	private String author;
	private String category;
	private String publisher;
	
}
