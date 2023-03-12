package com.example.newjiraback.service;

import com.example.newjiraback.dto.TodoType.TodoTypeCreateDTO;
import com.example.newjiraback.dto.TodoType.TodoTypeDTO;
import com.example.newjiraback.dto.TodoType.TodoTypeUpdateDTO;
import com.example.newjiraback.model.TodoType;

import java.util.List;

public interface TodoTypeService {
    public Long create(TodoTypeCreateDTO todoTypeCreateDTO);

    public void update(TodoTypeUpdateDTO TodoTypeUpdateDTO);

    public TodoType get(Long id);

    public List<TodoTypeDTO> getALL();
}
