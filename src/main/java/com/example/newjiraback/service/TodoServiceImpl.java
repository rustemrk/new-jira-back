package com.example.newjiraback.service;

import com.example.newjiraback.dto.mapper.TodoMapper;
import com.example.newjiraback.dto.todo.TodoCreateDTO;
import com.example.newjiraback.dto.todo.TodoDTO;
import com.example.newjiraback.dto.todo.TodoUpdateDTO;
import com.example.newjiraback.exception.ResourceNotFoundException;
import com.example.newjiraback.model.Todo;
import com.example.newjiraback.model.TodoStatus;
import com.example.newjiraback.model.TodoType;
import com.example.newjiraback.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.newjiraback.util.DateUtil.dateNow;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TodoStatusServiceImpl todoStatusServiceImpl;
    @Autowired
    private TodoTypeServiceImpl todoTypeServiceImpl;

    @Override
    public Long create(TodoCreateDTO todoCreateDTO) {
        TodoStatus status = todoStatusServiceImpl.get(todoCreateDTO.getStatusId());
        TodoType type = todoTypeServiceImpl.get(todoCreateDTO.getTypeId());

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
        TodoType type = todoTypeServiceImpl.get(todoUpdateDTO.getTypeId());
        TodoStatus status = todoStatusServiceImpl.get(todoUpdateDTO.getStatusId());

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
