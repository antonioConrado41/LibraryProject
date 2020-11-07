package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import classes.Book;
import classes.Borrow;
import classes.Reader;

public class FileReader {

	public static void main(String[] args) throws IOException {
		
	
		Data d1 = new Data();

		ArrayList<Book> bookList = d1.loadFile();
		ArrayList<Reader> readerList = d1.loadReader();
		d1.loadFile();
		Scanner sc = new Scanner(System.in);
		Boolean loop = true;
		
		do {
		System.out.println(" Welcome to the campus library - How can i help you?\n /////////////////////////////////////////////////////////////////");
		System.out.println ("Press 1 - Search for a specific book by title and/or author name" + "\n" +
		"Press 2 - List all books by title" + "\n" + 
		"Press 3 - List all books by author name alphabetical order." + "\n" + 
		"Press 4 - Search for a specific reader by name and/or ID" + "\n" +
		"Press 5 - List all users by alphabetical order" + "\n" +
		"Press 6 - List all users by ID order" + "\n" +
		"Press 7 - Register that a reader has borrowed a book." + "\n" +
		"Press 8 - Register that a reader has returned a book." + "\n" +
		"Press 9 - For a specific reader, list the books that they have borrowed." + "\n" +
		"Press 0 - EXIT");
		
		try {
			int option = Integer.parseInt(sc.nextLine());
			switch(option) {
			case 1: 
				System.out.println("Type book by title and/or author");
				String sBook = sc.nextLine() ;
				System.out.println(d1.bookSearch(sBook, bookList));
				break;
			case 2: 
				System.out.println("List of all books by title");
				System.out.println(d1.sortBooksByTitle(bookList));
				break;
			case 3: 
				System.out.println("List of all books by author name alphabetical order");
				System.out.println(d1.sortBooksByAuthorName(bookList));
				break;
			case 4: 
				System.out.println("Type the reader name and/or ID");
				String sReader = sc.nextLine() ;
				System.out.println(d1.readerSearch(sReader, readerList));
				break;
			case 5: 
				System.out.println("List of users by alphabetical order");
				System.out.println(d1.sortReadersByName(readerList));
				break;
			case 6: 
				System.out.println("List of users by ID order");
				System.out.println(d1.sortReadersById(readerList));
				break;
			case 7: 
				System.out.println("Register that a reader has borrowed a book");
				System.out.println("Type an ID reader");
				String id = sc.nextLine();
				System.out.println("Type a book title");
				String bookTitle = sc.nextLine();
				
				DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				String strDate = dt.format(now);
				
				String[] returnArray = {id, bookTitle, strDate};
				System.out.println(d1.registerBorrow(returnArray));
				break;
			case 8: 
				System.out.println("Register that a reader has returned a book");
				System.out.println("Type an ID reader");
				String idReader = sc.nextLine();
				System.out.println("Type a book title");
				String book = sc.nextLine();
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime timeNow = LocalDateTime.now();
				String strD = dtf.format(timeNow);
				
				String[] returnA = {idReader, book, strD};
				System.out.println(d1.registerReturn(returnA));
				break;
			case 9: 
				System.out.println("For a specific reader, list the books that they have borrowed.");
				System.out.println("Please type the reader ID");
				String ID = sc.nextLine();
				System.out.println(d1.listBorrowByID(Integer.parseInt(ID)));
				break;				
			case 0:
				loop = false;
				break;
			}
		}catch(NumberFormatException e) {
			System.out.println(e);
		}
		
		}while(loop);
		
	}

}



