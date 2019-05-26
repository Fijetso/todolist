package com.example.todolist.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.Model.Todo;
import com.example.todolist.Model.TodoList;
import com.example.todolist.Repository.TodoListRepository;
import com.example.todolist.Repository.TodoRepository;

@RestController
public class TodoController {
	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	private TodoListRepository todoListRepository;
	
    @GetMapping("/todo")
    public ResponseEntity<List<Todo>> getAll() {
    	List<Todo> todos = todoRepository.findAll();
    	if(todos.isEmpty() == true) {
    		throw new NullPointerException("Cannot find any Todo in the database");
    	}
        return new ResponseEntity<>(todos,HttpStatus.OK);
    }
    @GetMapping("/todo/{todoId}")
    public ResponseEntity<Todo> getById(@PathVariable(name="todoId") Long todoId) {
    	Optional<Todo> todo = todoRepository.findById(todoId);
    	if(todo.isPresent() == false) {
    		throw new NullPointerException("Cannot find any Todo with id ="+todoId);
    	}
        return new ResponseEntity<>(todo.get(),HttpStatus.OK);
    }
    @PostMapping("todolist/{listId}/todo")
    public void add(@PathVariable(name="listId") Long listId, @RequestBody Todo todo) {
    	Optional<TodoList> foundList = todoListRepository.findById(listId);
    	if(foundList.isPresent() == false) {
    		throw new NullPointerException("Cannot find any TodoList with id ="+listId);
    	}
    	todo.setTodoList(foundList.get());
    	todoRepository.save(todo);
    }
    @DeleteMapping("/todo/{todoId}")
    public void deleteById(@PathVariable(name="todoId") long todoId) {
    	if(todoRepository.findById(todoId).isPresent() == false) {
    		throw new IllegalArgumentException("Cannot find any Todo with Id="+todoId);
    	}
    	todoRepository.deleteById(todoId);
    }
}
