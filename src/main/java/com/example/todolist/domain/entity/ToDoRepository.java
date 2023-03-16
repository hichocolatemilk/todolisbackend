package com.example.todolist.domain.entity;

import com.example.todolist.domain.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {
}
