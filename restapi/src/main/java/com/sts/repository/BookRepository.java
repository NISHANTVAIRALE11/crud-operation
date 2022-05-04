package com.sts.repository;

import org.springframework.data.repository.CrudRepository;

import com.sts.entity.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{
  
	public Book findBookById(int id);
}
