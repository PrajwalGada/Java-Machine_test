package com.boot.anilg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id")
	private int id;
	
	private String book_type;
	private double price;
	
	@OneToOne(mappedBy = "bookCategory")
	@JsonBackReference
	private Author author;
	
	/*private boolean fantancy;
	private boolean adventure;
	private boolean romance;
	private boolean horror;
	private boolean thriller;
*/
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String book_type, double price, Author author) {
		super();
		this.id = id;
		this.book_type = book_type;
		this.price = price;
		this.author = author;
	}

	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook_type() {
		return book_type;
	}

	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	


}
