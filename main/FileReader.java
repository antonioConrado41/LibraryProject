package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import classes.Book;
import classes.Reader;

public class FileReader {

	public static void main(String[] args) throws FileNotFoundException {
		
	
		Data d1 = new Data();

		ArrayList<Book> bookList = d1.loadFile();
		ArrayList<Reader> readerList = d1.loadReader();
		
		System.out.println("Printing data ----------->");
		d1.loadFile();
		
		//System.out.println(d1.sortBooksById(bookList));
		//System.out.println(d1.sortReadersById(readerList));
		
		Scanner sc = new Scanner(System.in);
		
		do {
		System.out.println(" Welcome to the campus library - How can i help you?");
		System.out.println ("Press 1 - Search for a specific book by title and/or author name" + "\n" +
		"Press 2 - List all books by title" + "\n" + 
		"Press 3 - List all books by author name alphabetical order." + "\n" + 
		"Press 4 - Search for a specific reader by name and/or ID" + "\n" +
		
		"Press 4 - List all users by alphabetical and/or ID order." + "\n" +
		"Press 5 - Register that a reader has borrowed a book." + "\n" +
		"Press 6 - Register that a reader has returned a book." + "\n" +
		"Press 7 - For a specific reader, list the books that they have borrowed." + "\n" +
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
				System.out.println("List all books by title");
				System.out.println(d1.sortBooksByTitle(bookList));
				break;
			case 3: 
				System.out.println("List all books by author name alphabetical order");
				//In construction 
				break;
			case 4: 
				System.out.println("Search for a specific reader by name and/or ID");
				String sReader = sc.nextLine() ;
				System.out.println(d1.readerSearch(sReader, readerList));
				break;
			}
		}catch(NumberFormatException e) {
			System.out.println(e);
		}
		
		}while(true);
		
	}

	// ----------------------------Comparator

	public static class BookComparator implements Comparator<Book> {

		public int compare(Book b1, Book b2) {
			String titleOne = b1.getTitle();
			String titleTwo = b2.getTitle();
			return titleOne.compareTo(titleTwo);
		}

	}
	
			
}



