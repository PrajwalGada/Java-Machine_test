package com.boot.anilg.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "product_name")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String language;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Category bookCategory;

	/**
	 *  @OneToOne(mappedBy = "author") : mean Inside author table don't create extra column like book_bookId,
	 *  	 it is possible by 'mappedBy'='author', here 'author' is foreign key field name in Book class.
	 *  	Using above it recursive call from book to Author and Author to Book it's problem  
	 *  
	 *  @JsonBackReference - means don't back to Book table it work as a child, 
	 *  
	 * */
	@OneToOne(mappedBy = "product")
	@JsonBackReference
	private product product;

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int id, String firstName, String lastName, String language, Category bookCategory) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language = language;
		this.productCategory = productCategory;
	}

	public Product getproduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product_name [productCategory=" + productCategory + ", firstName=" + firstName + ", id=" + id + ", language="
				+ language + ", lastName=" + lastName + "]";
	}
	
	

}
