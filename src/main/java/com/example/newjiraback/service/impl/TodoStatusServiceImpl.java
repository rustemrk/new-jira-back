package com.example.newjiraback.service.impl;

import com.example.newjiraback.dto.mapper.TodoMapper;
import com.example.newjiraback.dto.mapper.TodoStatusMapper;
import com.example.newjiraback.dto.todo.TodoDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusCreateDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusUpdateDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusWithTodosDTO;
import com.example.newjiraback.exception.ResourceNotFoundException;
import com.example.newjiraback.model.TodoStatus;
import com.example.newjiraback.repository.TodoRepository;
import com.example.newjiraback.repository.TodoStatusRepository;
import com.example.newjiraback.service.TodoStatusService;
import com.example.newjiraback.util.UtDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoStatusServiceImpl implements TodoStatusService {
    @Autowired
    private TodoStatusRepository todoStatusRepository;
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Long create(TodoStatusCreateDTO todoStatusCreateDTO) {
        TodoStatus todoStatus = TodoStatus.builder()
                .name(todoStatusCreateDTO.getName())
                .createDate(UtDate.dateNow())
                .isSystem(false)
                .build();
        return todoStatusRepository.save(todoStatus).getId();
    }

    @Override
    public void update(TodoStatusUpdateDTO todoStatusUpdateDTO) {
        TodoStatus todoStatus = todoStatusRepository.findById(todoStatusUpdateDTO.getId()).orElseThrow(ResourceNotFoundException::new);
        todoStatus.setName(todoStatusUpdateDTO.getName());
        todoStatusRepository.save(todoStatus);
    }

    @Override
    public TodoStatus get(Long id) {
        return todoStatusRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<TodoStatusDTO> getALL() {
        List<TodoStatus> todoStatusList = todoStatusRepository.findAll();
        List<TodoStatusDTO> todoStatusDTOList = new ArrayList<>();

        todoStatusList.stream()
                .map(TodoStatusMapper.INSTANCE::toDTO)
                .forEach(todoStatusDTOList::add);

        return todoStatusDTOList;
    }

    @Override
    public List<TodoStatusWithTodosDTO> getAllWithTodos() {
        List<TodoStatus> todoStatuses = todoStatusRepository.findAll();
        List<TodoStatusWithTodosDTO> statusWithTodoDTOsList = new ArrayList<>();

        for (TodoStatus todoStatus : todoStatuses) {
            List<TodoDTO> todoDTOS = todoRepository.getTodosByStatusId(todoStatus.getId())
                    .stream()
                    .map(TodoMapper.INSTANCE::toDTO)
                    .toList();
            TodoStatusWithTodosDTO statusWithTodosDTO = TodoStatusMapper.INSTANCE.toDTOWithTodos(todoStatus);
            statusWithTodosDTO.setTodos(todoDTOS);
            statusWithTodoDTOsList.add(statusWithTodosDTO);
        }

        return statusWithTodoDTOsList;
    }
}
