package com.example.todolist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.Repository.TodoRepository;

@RestController
public class TodoController {
	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping("/todo")
	public getTodo()
	
}
