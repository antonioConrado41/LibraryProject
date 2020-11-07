package classes;

import java.util.ArrayList;

public class Sort {

	public ArrayList<Book> sortBooksByTitle(ArrayList<Book> books) {

		for (int i = 0; i < books.size(); i++) {
			for (int j = i + 1; j < books.size(); j++) {
				if (books.get(j).getTitle().compareTo(books.get(i).getTitle()) < 0)

				{
					Book temp = books.get(i);
					books.set(i, books.get(j));
					books.set(j, temp);

				}
			}
		}
		return books;
	}

	public ArrayList<Book> sortBooksByAuthorName(ArrayList<Book> books) {

		for (int i = 0; i < books.size(); i++) {
			for (int j = i + 1; j < books.size(); j++) {
				if (books.get(j).getAuthor().compareTo(books.get(i).getAuthor()) < 0)

				{
					Book temp = books.get(i);
					books.set(i, books.get(j));
					books.set(j, temp);

				}
			}
		}
		return books;
	}

	public ArrayList<Reader> sortReadersByName(ArrayList<Reader> users) {

		for (int i = 0; i < users.size(); i++) {
			for (int j = i + 1; j < users.size(); j++) {
				if (users.get(j).getName().compareTo(users.get(i).getName()) < 0)

				{
					Reader temp = users.get(i);
					users.set(i, users.get(j));
					users.set(j, temp);

				}
			}
		}
		return users;
	}

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
