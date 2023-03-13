package com.example.todolist.service;

import com.example.todolist.entity.ToDoEntity;
import com.example.todolist.repository.ToDoRepository;
import com.example.todolist.web.ToDoRequestUpdateDto;
import com.example.todolist.web.ToDoResponseDto;
import com.example.todolist.web.ToDoSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    @Transactional
    public ToDoEntity save(ToDoSaveRequestDto requestDto) {
        return toDoRepository.save(requestDto.toEntity());
    }

    public List<ToDoEntity> getList(){
        return toDoRepository.findAll();
    }

    @Transactional
    public Long update(Long id, ToDoRequestUpdateDto request){
        ToDoEntity entity = toDoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        entity.update(request.getName(), request.getContent());
        return id;
    }

    @Transactional
    public void delete(Long id){
        ToDoEntity entity = toDoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        toDoRepository.delete(entity);
    }

    public ToDoResponseDto findById(Long id) {
        ToDoEntity entity = toDoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new ToDoResponseDto(entity);
    }


//    @Transactional
//    public void delete(Long id){
//        ToDoEntity toDoEntity = toDoRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 없음" + id));
//        this.toDoRepository.delete(toDoEntity);
//    }


}

