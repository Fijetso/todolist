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

import com.example.todolist.Model.Book;
import com.example.todolist.Model.Todo;
import com.example.todolist.Model.TodoList;
import com.example.todolist.Repository.BookRepository;
import com.example.todolist.Repository.TodoListRepository;
import com.example.todolist.Repository.TodoRepository;

@RestController
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private TodoListRepository todoListRepository;
	@Autowired
	private TodoRepository todoRepository;

    @GetMapping("book")
    public ResponseEntity<List<Book>> getAll() {
    	List<Book> allBook = bookRepository.findAll();
    	if(allBook.isEmpty() == true) {
    		throw new NullPointerException("Cannot find any Book in the Database");
    	}
        return new ResponseEntity<>(allBook,HttpStatus.OK);
    }
    @GetMapping("book/{bookId}")
    public ResponseEntity<Book> getById(@PathVariable Long bookId) {
    	Optional<Book> book = bookRepository.findById(bookId);
    	if(book.isPresent() == false) {
    		throw new NullPointerException("Cannot find any Book with id ="+bookId);
    	}
        return new ResponseEntity<>(book.get(),HttpStatus.OK);
    }
    @PostMapping("/book")
    public void add(@RequestBody Book book) {
    	bookRepository.save(book);
    }
    @DeleteMapping("/book/{bookId}")
    public void deleteById(@PathVariable long bookId) {
    	Optional<Book> book = bookRepository.findById(bookId);
    	if(book.isPresent() == false) {
    		throw new NullPointerException("Cannot find any Book with id ="+bookId);
    	}
		List<TodoList> todoLists = book.get().getTodoLists();
    	if(todoLists.isEmpty()==false) {
    		for(TodoList eachList : todoLists) {
    			if (eachList.getTodos().isEmpty() == false) {
    	    		todoRepository.deleteAll(eachList.getTodos());
    			}
    		}
    		todoListRepository.deleteAll(todoLists);
    	}
    	bookRepository.deleteById(bookId);
    }
}
