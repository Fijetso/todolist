package com.example.todolist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.Model.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList, Long>{

}
