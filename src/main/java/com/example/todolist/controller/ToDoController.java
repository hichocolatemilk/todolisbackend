package com.example.todolist.controller;

import com.example.todolist.domain.entity.ToDoEntity;
import com.example.todolist.service.ToDoService;
import com.example.todolist.web.ToDoRequestUpdateDto;
import com.example.todolist.web.ToDoResponseDto;
import com.example.todolist.web.ToDoSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;


    @GetMapping("/api/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }


    @PostMapping("/api/add")
    public ResponseEntity<String> add(@RequestBody ToDoSaveRequestDto requestDto){
        toDoService.save(requestDto);
        return ResponseEntity.ok("NEW ADD");
    }
    @GetMapping("/api/getall")
    public List<ToDoEntity> getAll(){
        return  toDoService.getList();
    }

    @GetMapping("/api/add/{id}")
    public ToDoResponseDto getId(@PathVariable Long id){
        return  toDoService.findById(id);
    }
    @PutMapping("/api/add/{id}")
    public Long update(@PathVariable Long id, @RequestBody ToDoRequestUpdateDto requestDto){
        return toDoService.update(id, requestDto);
    }

    @DeleteMapping("/api/add/{id}")
    public Long delete(@PathVariable Long id){
        toDoService.delete(id);
        return id;
    }
}
