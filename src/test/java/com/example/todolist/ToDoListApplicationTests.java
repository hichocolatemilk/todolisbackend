package com.example.todolist;

import com.example.todolist.entity.ToDoEntity;
import com.example.todolist.repository.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToDoListApplicationTests {

    @Autowired
    private ToDoRepository toDoRepository;
    @Test
    void testJpa() {
        ToDoEntity todo = new ToDoEntity();
        todo.setContent("밥먹기");
        todo.setCompleted(Boolean.TRUE);
        this.toDoRepository.save(todo);
    }

}
