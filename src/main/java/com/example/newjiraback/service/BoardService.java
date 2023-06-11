package com.example.newjiraback.service;

import com.example.newjiraback.dto.todo.TodoKanbanOrderDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusWithTodosDTO;

import java.util.List;
import java.util.Map;

public interface BoardService {

    List<TodoStatusWithTodosDTO> search(Map<String, Object> filter);

    void saveOrder(List<TodoKanbanOrderDTO> kanbanOrderDTOList);

}
