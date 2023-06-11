package com.example.newjiraback.service;

import com.example.newjiraback.dto.todo.TodoCreateDTO;
import com.example.newjiraback.dto.todo.TodoDTO;
import com.example.newjiraback.dto.todo.TodoUpdateDTO;

public interface TodoService {
    Long create(TodoCreateDTO todoCreateDTO);

    void update(TodoUpdateDTO todoUpdateDTO);

    TodoDTO get(Long id);

}
