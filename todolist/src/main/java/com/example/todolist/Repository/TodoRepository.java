package com.example.todolist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.Model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
