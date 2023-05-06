package com.example.newjiraback.service;

import com.example.newjiraback.dto.todo.TodoCreateDTO;
import com.example.newjiraback.dto.todo.TodoDTO;
import com.example.newjiraback.dto.todo.TodoKanbanOrderDTO;
import com.example.newjiraback.dto.todo.TodoUpdateDTO;

import java.util.List;

public interface TodoService {
    public Long create(TodoCreateDTO todoCreateDTO);

    public void update(TodoUpdateDTO todoUpdateDTO);

    public TodoDTO get(Long id);

    public void saveKanbanOrder(List<TodoKanbanOrderDTO> kanbanOrderDTOList);
}
