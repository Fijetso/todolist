package com.example.todolist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.Model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
