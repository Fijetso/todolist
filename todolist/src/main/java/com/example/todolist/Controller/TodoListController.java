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
public class TodoListController {
	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	private TodoListRepository todoListRepository;

    @GetMapping("todolist")
    public ResponseEntity<List<TodoList>> getAll() {
    	List<TodoList> allTodoList = todoListRepository.findAll();
    	if(allTodoList.isEmpty() == true) {
    		throw new NullPointerException("Cannot find any TodoList in the Database");
    	}
        return new ResponseEntity<>(allTodoList,HttpStatus.OK);
    }
    @GetMapping("todolist/{listId}")
    public ResponseEntity<TodoList> getById(@PathVariable Long listId) {
    	Optional<TodoList> todoList = todoListRepository.findById(listId);
    	if(todoList.isPresent() == false) {
    		throw new NullPointerException("Cannot find any TodoList with id ="+listId);
    	}
        return new ResponseEntity<>(todoList.get(),HttpStatus.OK);
    }
    @PostMapping("/todolist")
    public void add(@RequestBody TodoList todoList) {
    	todoListRepository.save(todoList);
    }
    @DeleteMapping("/todolist/{listId}")
    public void deleteById(@PathVariable long listId) {
    	Optional<TodoList> todoList = todoListRepository.findById(listId);
    	if(todoList.isPresent() == false) {
    		throw new NullPointerException("Cannot find any TodoList with id ="+listId);
    	}
		List<Todo> content = todoList.get().getTodos();
    	if(content.isEmpty()==false) {
    		todoRepository.deleteAll(content);
    	}
    	todoListRepository.deleteById(listId);
    }
}
