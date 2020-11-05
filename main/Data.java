package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import classes.Book;
import classes.Reader;

public class Data {

	// ------------------------------loadFile
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
			if (b.getAuthor().equalsIgnoreCase(s) || b.getTitle().equalsIgnoreCase(s)) {
				System.out.println(b);
				found = true;
			}
		}
		if (found == false) {
			System.out.println("Book not found");
		}
		return books;
	}

	// ---------------------------------------------------searching readers

	public ArrayList<Reader> readerSearch(String v, ArrayList<Reader> readers) {

		boolean found = false;
		for (Reader r : readers) {
			if (v.matches("[0-9]+") && r.getID() == Integer.parseInt(v)) {
				System.out.println(r);
				found = true;
			}
			if (r.getName().equalsIgnoreCase(v)) {
				System.out.println(r);
				found = true;
			}
		}
		if (found == false) {
			System.out.println("Reader not found!");
		}
		return readers;
	}

	// ------------------------------sortBookByTitle

	public ArrayList<Book> sortBooksByTitle(ArrayList<Book> books) {

		for (int i = 0; i < books.size(); i++) {
			for (int j = i + 1; j < books.size(); j++) {
				if (books.get(j).getTitle().compareTo(books.get(i).getTitle()) < 0) {
					Book temp = books.get(i);
					books.set(i, books.get(j));
					books.set(j,  temp);
					
				}
			}
	}
		return books;}

	// ------------------------------sortBookById
	public ArrayList<Book> sortBooksById(ArrayList<Book> books) {
		for (int i = 0; i < books.size(); i++) {
			for (int j = 0; j < books.size() - 1; j++) {
				if (books.get(j).getID() > books.get(j + 1).getID()) {
					books.add(j, books.get(j + 1));
					books.remove(j + 2);
				}
			}
		}
		return books;
	}

	// --------------------------------------sortReadersByID
	public ArrayList<Reader> sortReadersById(ArrayList<Reader> readers) {
		for (int i = 0; i < readers.size(); i++) {
			for (int j = 0; j < readers.size() - 1; j++) {
				if (readers.get(j).getID() > readers.get(j + 1).getID()) {
					readers.add(j, readers.get(j + 1));
					readers.remove(j + 2);
				}
			}
		}
		return readers;
	}

}
