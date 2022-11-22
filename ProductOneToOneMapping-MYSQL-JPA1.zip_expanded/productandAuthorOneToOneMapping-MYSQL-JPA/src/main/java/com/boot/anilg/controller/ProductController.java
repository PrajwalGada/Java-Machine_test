package com.boot.anilg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.anilg.entities.Book;
import com.boot.anilg.exception.BookNotFoundException;
import com.boot.anilg.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	ProductService PraductService;
	
	@GetMapping("/product")
	public ResponseEntity<List<product>> getAllProduct(){
		return new ResponseEntity<List<Product>>(productService.getAllProduct(), HttpStatus.CREATED);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<product> getProduct(@PathVariable("id") int id){
		Product findProduct = productService.find productById(id);
		return ResponseEntity.ok(findproduct);
	}
	
	@PostMapping("/product")
	public ResponseEntity<?> saveproduct(@RequestBody Product product){
		Product searchproduct;
		try {
			searchproduct = productService.saveProduct(product);
			return ResponseEntity.of(Optional.of(searchproduct));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable int id){
		Product resultProduct;
		try {
			resultProduct = productService.updateProduct(product, id);
			return ResponseEntity.ok(resultProduct) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BookNotFoundException("something goes wrong in request");
		}
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Void> deleteProductById(@PathVariable int id){
			productService.deleteproduct(id);
			return ResponseEntity.ok().build();
	}
}
