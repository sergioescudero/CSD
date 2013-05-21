package com.sergio.csd.TestHamcrest;

public class Book {
	private final Long id;
	private final String isbn;
	private final String title;

	public Book(final Long id, final String isbn, final String title) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + "]";
	}
}
