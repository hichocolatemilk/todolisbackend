package com.example.todolist;

import com.example.todolist.domain.entity.ToDoEntity;
import com.example.todolist.domain.entity.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToDoListApplicationTests {

    @Autowired
    private ToDoRepository ToDoRepository;
    @Test
    void testJpa() {
        ToDoEntity todo = ToDoEntity.builder()
                .name("HI")
                .content("밥먹기")
                .build();
        ToDoRepository.save(todo);
        System.out.println(todo);
    }

}
