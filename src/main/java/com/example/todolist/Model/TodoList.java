package com.example.todolist.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TodoList {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany(mappedBy = "list", fetch = FetchType.LAZY)
	private List<Todo> todoList;

	public TodoList() {
		super();
	}

	public TodoList(Long id, String name, List<Todo> todoList) {
		super();
		this.id = id;
		this.name = name;
		this.todoList = todoList;
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

	public List<Todo> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<Todo> todoList) {
		this.todoList = todoList;
	}
}
