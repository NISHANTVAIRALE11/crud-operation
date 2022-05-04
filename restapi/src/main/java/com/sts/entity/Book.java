package com.sts.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String title;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Author auther;
	
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name, String title, Author auther) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.auther = auther;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuther() {
		return auther;
	}

	public void setAuther(Author auther) {
		this.auther = auther;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", title=" + title + ", auther=" + auther + "]";
	}
	
	
}
