package com.example.todolist.web;

import com.example.todolist.entity.ToDoEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ToDoSaveRequestDto {
    private String content;
    private String name;

    @Builder
    public ToDoSaveRequestDto(String content, String name){
        this.content = content;
        this.name = name;
    }

    public ToDoEntity toEntity(){
        return ToDoEntity.builder()
                .content(content)
                .name(name)
                .build();

    }
}
