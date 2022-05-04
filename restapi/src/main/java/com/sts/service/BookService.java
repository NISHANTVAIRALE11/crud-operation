package com.sts.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sts.entity.Book;
import com.sts.repository.BookRepository;

@Component
public class BookService {

	//static List<Book> list=new ArrayList();
//           
//	static {
//		list.add(new Book(1,"nishant","java by nishant","nishant vairale"));
//		list.add(new Book(2,"nikhil","python by nikhil","nikhil khade"));
//		list.add(new Book(3,"aniket","sql by aniket","aniket wakde"));
//		}
	@Autowired
	private BookRepository bookrepsitory;
	// fetching all the book
	public List<Book> getBooks(){
		List<Book> list=(List<Book>) bookrepsitory.findAll();
		return list;
	}
	
	// fetching single book
	public Book getBookById(int id) {
		
		Book book=null;
		
		  try {
			//  book= list.stream().filter(e-> e.getId()==id).findFirst().get();
			  book=bookrepsitory.findBookById(id);
		  }
		  catch(Exception e) {
			  e.printStackTrace(); 
			  }
		  return book;
	}
	
	// inserting the book
	public Book addBook(Book book) {
		
		//list.add(book);
		Book b=bookrepsitory.save(book);
		return b; 
	}
	
	// deleting the book
	public void deleteBook(int id) {
		
		//return (Book) (list=list.stream().filter(book->book.getId()!=id).collect(Collectors.toList()));
	    bookrepsitory.deleteById(id);
	    
	}
	
	//  updating the book
	public Book updateBook(Book book,int id) {
//		list=list.stream().map(b->{
//		if(b.getId()==id) {
//			b.setName(book.getName());
//			b.setTitle(book.getTitle());
//			b.setAuther(book.getAuther());
//			}
//			return b;
//		} ).collect(Collectors.toList());
//		return book;
		book.setId(id);
		bookrepsitory.save(book);
		return book;
	}
	
}