package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import classes.Book;
import classes.Borrow;
import classes.Reader;

public class Data {

	public ArrayList<Book> loadFile() throws FileNotFoundException {

		FileInputStream file = new FileInputStream("books.txt");
		String strline = "";
		ArrayList<Book> books = new ArrayList<Book>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
			strline = br.readLine();
			while (strline != null) {
				String[] parts = strline.split(",");
				books.add(new Book(Integer.parseInt(parts[0]), parts[1], parts[2]));
				// System.out.println(strline);
				strline = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return books;
	}

	// -------------------------------------loadReader
	public ArrayList<Reader> loadReader() throws FileNotFoundException {

		FileInputStream file = new FileInputStream("readers.txt");
		String strline = "";
		ArrayList<Reader> readers = new ArrayList<Reader>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
			strline = br.readLine();
			while (strline != null) {
				String[] parts = strline.split(",");
				readers.add(new Reader(Integer.parseInt(parts[0]), parts[1], parts[2]));
				// System.out.println(strline);
				strline = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return readers;
	}

	
	public ArrayList<Book> bookSearch(String s, ArrayList<Book> books) {

		boolean found = false;
		for (Book b : books) {
			if (b.getTitle().toLowerCase().contains(s.trim().toLowerCase()) || b.getAuthor().toLowerCase().contains(s.trim().toLowerCase())) {
			//if (b.getAuthor().equalsIgnoreCase(s) || b.getTitle().equalsIgnoreCase(s)) {
				System.out.println(b);
				found = true;
			}
		}
		if (found == false) {
			System.out.println("Book not found");
		}
		return books;
	}

	
	public ArrayList<Reader> readerSearch(String v, ArrayList<Reader> readers) {

		boolean found = false;
		for (Reader r : readers) {
			if (v.matches("[0-9]+") && r.getID() == Integer.parseInt(v)) {
				System.out.println(r);
				found = true;
			}
			if(r.getName().toLowerCase().contains(v.trim().toLowerCase())) {
			//if (r.getName().equalsIgnoreCase(v)) {
				System.out.println(r);
				found = true;
			}
		}
		if (found == false) {
			System.out.println("Reader not found!");
		}
		return readers;
	}

	public String registerBorrow(String[] returnArray) throws IOException {

		try {
			BufferedWriter writeBorrow = new BufferedWriter(new FileWriter("borrows.txt", true));
			writeBorrow.write(returnArray[0] + "," + returnArray[1] + "," + returnArray[2] + "\n");
			writeBorrow.close();
		} catch (IOException e) {
			System.out.println("An error has ocurred");
			e.printStackTrace();
		}

		return "Borrow Registered sucessfully";
	}


	public String registerReturn(String[] returnArray) throws IOException {

		try {
			BufferedWriter writeBorrow = new BufferedWriter(new FileWriter("returns.txt", true));
			writeBorrow.write(returnArray[0] + "," + returnArray[1] + "," + returnArray[2] + "\n");
			writeBorrow.close();
		} catch (IOException e) {
			System.out.println("An error has ocurred");
			e.printStackTrace();
		}

		return "Book Returned sucessfully";
	}

	
	public ArrayList<Borrow> listBorrowByID(int id) throws FileNotFoundException {
		FileInputStream file = new FileInputStream("borrows.txt");
		String strline = "";
		ArrayList<Borrow> borrows = new ArrayList<Borrow>();
		ArrayList<Borrow> newList = new ArrayList<Borrow>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
			strline = br.readLine();
			while (strline != null) {
				String[] parts = strline.split(",");

				borrows.add(new Borrow(Integer.parseInt(parts[0]), parts[1], parts[2]));
				strline = br.readLine();
			}
			for (int i = 0; i < borrows.size(); i++) {
				if (id == borrows.get(i).readerID) {
					newList.add(borrows.get(i));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newList;
	}

}
