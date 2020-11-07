package classes;

import java.util.ArrayList;
import java.util.Comparator;

public class Book {

	private int ID;
	private String title;
	private String author;

	public Book(int ID, String title, String author) {
		this.ID = ID;
		this.title = title;
		this.author = author;
	}

	public Book() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	@Override
	public boolean equals(Object ref) {
		Book other = (Book) ref;

		if ((this.ID == other.ID) && (this.title.equalsIgnoreCase(other.title))
				&& (this.author.equalsIgnoreCase(other.author))) {
			return true;
		} else {
			return false;
		}
	}
	
	
	@Override
	public String toString() {
		return "Book ID: " + ID + " Title: " + title + " Author: " + author;
	}
	
	public int compare(Book b1, Book b2) {
		String titleOne = b1.getTitle();
		String titleTwo = b2.getTitle();
		return titleOne.compareTo(titleTwo);
	}

	

	  
	  
	  
	}
	

