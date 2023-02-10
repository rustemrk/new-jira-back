package com.example.newjiraback.service;

import com.example.newjiraback.dto.mapper.TodoMapper;
import com.example.newjiraback.dto.todo.TodoCreateDTO;
import com.example.newjiraback.dto.todo.TodoDTO;
import com.example.newjiraback.dto.todo.TodoUpdateDTO;
import com.example.newjiraback.exception.TodoNotFoundException;
import com.example.newjiraback.model.Todo;
import com.example.newjiraback.model.TodoStatus;
import com.example.newjiraback.model.TodoType;
import com.example.newjiraback.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.newjiraback.util.DateUtil.dateNow;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TodoStatusService todoStatusService;
    @Autowired
    private TodoTypeService todoTypeService;

    public void create(TodoCreateDTO todoCreateDTO) throws Exception {
        TodoStatus status = todoStatusService.get(TodoStatus.TO_DO);
        TodoType type = todoTypeService.get(todoCreateDTO.getTypeId());

        Todo todo = Todo.builder()
                .title(todoCreateDTO.getTitle())
                .description(todoCreateDTO.getDescription())
                .type(type)
                .status(status)
                .createDate(dateNow())
                .build();
        todoRepository.save(todo);
    }

    public void update(TodoUpdateDTO todoUpdateDTO) throws Exception {
        Todo todo = todoRepository.findById(todoUpdateDTO.getId()).orElseThrow(TodoNotFoundException::new);
        TodoType type = todoTypeService.get(todoUpdateDTO.getTypeId());
        TodoStatus status = todoStatusService.get(todoUpdateDTO.getStatusId());

        todo.setTitle(todoUpdateDTO.getTitle());
        todo.setDescription(todoUpdateDTO.getDescription());
        todo.setType(type);
        todo.setStatus(status);
        todo.setUpdateDate(dateNow());

        todoRepository.save(todo);
    }

    public TodoDTO get(Long id) throws Exception {
        Todo todo = todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
        return TodoMapper.INSTANCE.toDTO(todo);
    }
}
