package com.kimdohee.assignment.bookstore;

import java.util.Date;

public class Book {

		String id;
		String title;
		double price;
		String author;
		String description;
		String genre;
		Date publishDate;

		public Book(String id, String title, double price, String author, String description, String genre,
				Date publishDate) {
				this.id = id;
				this.title = title;
				this.price = price;
				this.author = author;
				this.description = description;
				this.genre = genre;
				this.publishDate = publishDate;
		}

		public java.lang.String toString() {
				return java.lang.String.format("%s | %s | %.0f | %s | %s | %s | %s",
						id, title, price, author, description, genre, publishDate);
		}
}
