package classes;

import java.sql.Date;

public class Borrow {
	
	public int readerID;
	String bookTitle;
	String date;
	
	
	public Borrow(int readerID, String bookTitle, String date) {
		this.readerID = readerID;
		this.bookTitle = bookTitle;
		this.date = date;
	}
	


	@Override
	public String toString() {
		return "Reader ID: " + readerID + " Book Title: " + bookTitle + " Date : " + date;
	}
	

}
