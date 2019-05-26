package com.example.todolist.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Todo {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private boolean isDone;
	@ManyToOne
	@JoinColumn(name = "todoList", referencedColumnName = "id")
	private TodoList list;

	public Todo() {
		super();
	}

	public Todo(Long id, String name, boolean isDone, TodoList list) {
		super();
		this.id = id;
		this.name = name;
		this.isDone = isDone;
		this.list = list;
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

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public TodoList getList() {
		return list;
	}

	public void setList(TodoList list) {
		this.list = list;
	}
}
