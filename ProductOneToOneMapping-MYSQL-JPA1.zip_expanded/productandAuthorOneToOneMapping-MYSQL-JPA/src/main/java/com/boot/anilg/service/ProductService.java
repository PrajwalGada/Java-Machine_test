package com.boot.anilg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.anilg.dao.BookRepository;
import com.boot.anilg.entities.Book;
import com.boot.anilg.exception.BookNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	// find all product
	public List<Product> getAllProduct(){
		List<Product> productkList = (List<Product>)productRepository.findAll();
		System.out.println(productList);
		if(productList.size()<=0) {
			System.err.println("empty product list");	
			throw new ProductNotFoundException("Product are not available right now");
		}
		return productList;
	}
	
	// find product by using ID
	public Product findProductById(int id) {
		return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("product not found by given id : "+id));
	}
	
	// save records
	public Product saveProduct(Product product) throws Exception {
		try {
			System.out.println("before saving product : \n"+product);
			Product savedProduct = productRepository.save(product);
			System.out.println("after saving product : \n"+savedProduct);
			return savedProduct;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("given record not saved");
		}		
	}

	// update records
	public Product updateProduct(Product product, int id) {
			Product findProduct = findProductById(id);
				findProduct.setName(product.getName());
				findProduct.setBook_name(product.getProduct_name());
				try {
					return saveProduct(findProduct);
				} catch (Exception e) {
					e.printStackTrace();
					throw new ProductNotFoundException("record not updated with given id :"+id);
				}
	}
	// delete records
	public void deleteRecord(int id) {
		this.findRecordById(id);
		productRepository.deleteById(id);
	}
	
}
