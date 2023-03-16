package com.example.todolist.web;

import com.example.todolist.domain.entity.ToDoEntity;
import lombok.Getter;

@Getter
public class ToDoResponseDto {

    private Long id;
    private String name;
    private String content;

    public ToDoResponseDto(ToDoEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.content = entity.getContent();
    }
}
