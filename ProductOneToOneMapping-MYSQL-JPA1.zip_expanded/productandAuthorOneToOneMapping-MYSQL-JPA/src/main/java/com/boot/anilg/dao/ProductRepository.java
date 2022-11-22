package com.boot.anilg.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.anilg.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Product, Integer> {

}
