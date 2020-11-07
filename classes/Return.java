package classes;

import java.sql.Date;

public class Return {
	
	int readerID;
	String bookTitle;
	Date date;

	public Return(int readerID, String bookTitle, Date date) {
		this.readerID = readerID;
		this.bookTitle = bookTitle;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Reader ID: " + readerID + " Book Title: " + bookTitle + " Date: " + date;
	}
}
