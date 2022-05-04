package com.sts.controller;

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

import com.sts.entity.Book;
import com.sts.service.BookService;

@RestController
public class BookController {

	
	@Autowired
	 BookService bookservice;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks(){
		
	   List<Book> list=bookservice.getBooks();	
	   if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list)) ;
	}
	
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookByid(@PathVariable("id")int id) {
		Book book=bookservice.getBookById(id);
		if(book==null) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b =bookservice.addBook(book);
		if(b!=null) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		System.out.println(b);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") int id) {
		try {
		   bookservice.deleteBook(id);		
		   return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}catch(Exception e) {
				e.printStackTrace();
		return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id") int id) {
		
		Book b=bookservice.updateBook(book,id);
		if(b!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(book);
		}
		return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).build();
	}
	
	
	
	
		/*
		 * @GetMapping("/books") 
		 * public List<Book> getBooks(){
		 *  List<Book> list=bookservice.getBooks(); 
		 *  return list;
		 *   }
		 * 
		 * @GetMapping("/book/{id}")
		 *  public Book getBookByid(@PathVariable("id")int id)
		 * {
		 *  Book book=bookservice.getBookById(id);
		 *   return book;
		 *    }
		 * 
		 * @PostMapping("/books") 
		 * public Book addBook(@RequestBody Book book) {
		 *  Book b =bookservice.addBook(book);
		 *   System.out.println(b); 
		 *   return b; 
		 *   }
		 * 
		 * @DeleteMapping("/books/{id}")
		 *  public void deleteBook(@PathVariable("id") int
		 * id) {
		 * 
		 * bookservice.deleteBook(id);
		 *  }
		 * 
		 * @PutMapping("/books/{id}")
		 *  public Book updateBook(@RequestBody Book
		 * book,@PathVariable("id") int id) {
		 *  Book b=bookservice.updateBook(book,id);
		 * return b; 
		 * }
		 */
}
