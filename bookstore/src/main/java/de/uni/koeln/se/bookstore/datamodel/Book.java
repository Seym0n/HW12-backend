package de.uni.koeln.se.bookstore.datamodel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	private String name;
	private String author;
	private Integer dateYear;
	private Double price;
	
	public Book() {
		
	}
	
	public Book(String name, String author, Integer dateYear, Double price) {
		this.name = name;
		this.author = author;
		this.dateYear = dateYear;
		this.price = price;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public Integer getDateYear() {
		return dateYear;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setDateYear(Integer dateYear) {
		this.dateYear = dateYear;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
}
