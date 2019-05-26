package com.example.todolist.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TodoList {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String content;
	@ManyToOne
	@JoinColumn(name = "bookId", referencedColumnName = "id")
	private Book book;
	@OneToMany(mappedBy = "todoList", fetch = FetchType.LAZY)
	private List<Todo> todos;

	public TodoList() {
		super();
	}

	public TodoList(Long id, String name, String content, Book book, List<Todo> todos) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.book = book;
		this.todos = todos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
