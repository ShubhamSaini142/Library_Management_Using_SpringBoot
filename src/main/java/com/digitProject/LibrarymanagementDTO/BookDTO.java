package com.digitProject.LibrarymanagementDTO;

import com.digitProject.Librarymanagement.Entity.User;

import jakarta.persistence.ManyToOne;

public class BookDTO {
	private Long id;

	private String title;

	private String author;

	private boolean borrowed;

    private User borrowedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	public User getBorrowedBy() {
		return borrowedBy;
	}

	public void setBorrowedBy(User borrowedBy) {
		this.borrowedBy = borrowedBy;
	}




	
	

}
