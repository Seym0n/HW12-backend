package de.uni.koeln.se.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.uni.koeln.se.bookstore.repository.BookRepo;
import de.uni.koeln.se.bookstore.datamodel.Book;

@Service
public class BookService {
	@Autowired
	private BookRepo bookRepo;
	
	public List<Book> findBooks(){
		return bookRepo.findAll();
	}
	
	public Optional<Book> fetchBook(int id){
		return bookRepo.findById(id);
	}
	
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book oldestBook() {
		List<Book> bookList = bookRepo.findAll();
		Book oldestBook = null;
		int yearOldestBook = Integer.MAX_VALUE;
		for(Book singleBook: bookList) {
			if(singleBook.getDateYear() < yearOldestBook) {
				oldestBook = singleBook;
				yearOldestBook = singleBook.getDateYear();
			}
		}
		return oldestBook;
	}
	
	public Book latestBook() {
		List<Book> bookList = bookRepo.findAll();
		Book latestBook = null;
		int yearLatestBook = Integer.MIN_VALUE;
		for(Book singleBook: bookList) {
			if(singleBook.getDateYear() > yearLatestBook) {
				latestBook = singleBook;
				yearLatestBook = singleBook.getDateYear();
			}
		}
		return latestBook;
	}
	
	public boolean deleteBook(int id) {
		boolean status;
		try {
			bookRepo.deleteById(id);
			status = true;
		}
		catch(Exception e) {
			status = false;
		}
		return status;
	}
	
	public void addExampleBooks() {
		bookRepo.save(new Book("Die Arena", "Stephen King", 2009, 13.49));
		bookRepo.save(new Book("Die Kunst des guten Lebens", "Rolf Dobelli", 2017, 14.99));
		bookRepo.save(new Book("Die Kunst des klugen Handels", "Rolf Dobelli", 2014, 11.99));
		bookRepo.save(new Book("Atomic Habits", "James Clear", 2020, 12.99));
	}
}
