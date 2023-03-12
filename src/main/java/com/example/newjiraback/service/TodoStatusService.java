package com.example.newjiraback.service;

import com.example.newjiraback.dto.todoStatus.TodoStatusCreateDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusUpdateDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusWithTodosDTO;
import com.example.newjiraback.model.TodoStatus;

import java.util.List;

public interface TodoStatusService {
    public Long create(TodoStatusCreateDTO todoStatusCreateDTO);

    public void update(TodoStatusUpdateDTO todoStatusUpdateDTO);

    public TodoStatus get(Long id);

    public List<TodoStatusDTO> getALL();

    public List<TodoStatusWithTodosDTO> getAllWithTodos();
}
