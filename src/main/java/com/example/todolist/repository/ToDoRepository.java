package com.example.todolist.repository;

import com.example.todolist.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {
}
