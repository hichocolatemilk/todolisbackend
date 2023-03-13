package com.example.todolist.web;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ToDoRequestUpdateDto {
    private String name;
    private String content;

    @Builder
    public ToDoRequestUpdateDto(String name, String content){
        this.name = name;
        this.content = content;
    }
}
