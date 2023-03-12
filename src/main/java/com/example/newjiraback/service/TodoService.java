package com.example.newjiraback.service;

import com.example.newjiraback.dto.todo.TodoCreateDTO;
import com.example.newjiraback.dto.todo.TodoDTO;
import com.example.newjiraback.dto.todo.TodoUpdateDTO;

public interface TodoService {
    public Long create(TodoCreateDTO todoCreateDTO);

    public void update(TodoUpdateDTO todoUpdateDTO);

    public TodoDTO get(Long id);
}
