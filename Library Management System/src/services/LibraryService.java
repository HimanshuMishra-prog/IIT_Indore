package services;

import models.Book;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
	private final String booksFile = "data/book.json";

	public List<Book> loadBooks() {
		List<Book> books = new ArrayList<>();
		try {
			String content = new String(Files.readAllBytes(Paths.get(booksFile)));
			JSONArray booksArray = new JSONArray(content);
			for (int i = 0; i < booksArray.length(); i++) {
				JSONObject bookJson = booksArray.getJSONObject(i);
				Book book = new Book(bookJson.getString("id"), bookJson.getString("title"),
						bookJson.getString("author"), bookJson.getBoolean("isIssued"));
				books.add(book);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return books;
	}

	public void saveBooks(List<Book> books) {
		JSONArray booksArray = new JSONArray();
		for (Book book : books) {
			JSONObject bookJson = new JSONObject();
			bookJson.put("id", book.getId());
			bookJson.put("title", book.getTitle());
			bookJson.put("author", book.getAuthor());
			bookJson.put("isIssued", book.isIssued());
			booksArray.put(bookJson);
		}
		try {
			Files.write(Paths.get(booksFile), booksArray.toString(4).getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addBook(Book book) {
		List<Book> books = loadBooks();
		books.add(book);
		saveBooks(books);
	}

	public void removeBook(String bookId) {
		List<Book> books = loadBooks();
		books.removeIf(book -> book.getId().equals(bookId));
		saveBooks(books);
	}

	public void changeBookStatus(String bookId, boolean isIssued) {
		List<Book> books = loadBooks();
		for (Book book : books) {
			if (book.getId().equals(bookId)) {
				if(book.isIssued() && isIssued) {
					System.out.println("Book is already issued to someone");
					continue;
				}
				book.setIssued(isIssued);
			}
		}
		saveBooks(books);
	}

	public boolean searchBook(String title) {
		List<Book> books = loadBooks();
		for (Book book : books) {
			if (book.getTitle().equals(title)) {
				return true;
			}
		}
		return false;
	}

}
