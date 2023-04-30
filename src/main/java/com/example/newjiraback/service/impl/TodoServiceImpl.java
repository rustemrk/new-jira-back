package com.example.newjiraback.service.impl;

import com.example.newjiraback.dto.mapper.TodoMapper;
import com.example.newjiraback.dto.todo.TodoCreateDTO;
import com.example.newjiraback.dto.todo.TodoDTO;
import com.example.newjiraback.dto.todo.TodoUpdateDTO;
import com.example.newjiraback.exception.ResourceNotFoundException;
import com.example.newjiraback.model.Todo;
import com.example.newjiraback.model.TodoStatus;
import com.example.newjiraback.model.TodoType;
import com.example.newjiraback.repository.TodoRepository;
import com.example.newjiraback.service.TodoService;
import com.example.newjiraback.service.TodoStatusService;
import com.example.newjiraback.service.TodoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.newjiraback.util.DateUtil.dateNow;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TodoStatusService todoStatusService;
    @Autowired
    private TodoTypeService todoTypeService;

    @Override
    public Long create(TodoCreateDTO todoCreateDTO) {
        TodoStatus status = todoStatusService.get(todoCreateDTO.getStatusId());
        TodoType type = todoTypeService.get(todoCreateDTO.getTypeId());

        Todo todo = Todo.builder()
                .title(todoCreateDTO.getTitle())
                .description(todoCreateDTO.getDescription())
                .type(type)
                .status(status)
                .createDate(dateNow())
                .build();
        return todoRepository.save(todo).getId();
    }

    @Override
    public void update(TodoUpdateDTO todoUpdateDTO) {
        Todo todo = todoRepository.findById(todoUpdateDTO.getId()).orElseThrow(ResourceNotFoundException::new);
        TodoType type = todoTypeService.get(todoUpdateDTO.getTypeId());
        TodoStatus status = todoStatusService.get(todoUpdateDTO.getStatusId());

        todo.setTitle(todoUpdateDTO.getTitle());
        todo.setDescription(todoUpdateDTO.getDescription());
        todo.setType(type);
        todo.setStatus(status);
        todo.setUpdateDate(dateNow());

        todoRepository.save(todo);
    }

    @Override
    public TodoDTO get(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return TodoMapper.INSTANCE.toDTO(todo);
    }
}
