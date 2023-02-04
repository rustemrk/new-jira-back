package com.example.newjiraback.service;

import com.example.newjiraback.dto.TodoDTO;
import com.example.newjiraback.dto.mapper.TodoMapper;
import com.example.newjiraback.entity.Todo;
import com.example.newjiraback.entity.TodoStatus;
import com.example.newjiraback.entity.TodoType;
import com.example.newjiraback.exception.TodoNotFoundException;
import com.example.newjiraback.repository.TodoRepository;
import lombok.SneakyThrows;
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

    public TodoDTO create(TodoDTO todoDTO) {
        String title = todoDTO.getTitle();
        String description = todoDTO.getDescription();
        TodoStatus status = todoStatusService.get(TodoStatus.TO_DO);
        TodoType type = todoTypeService.get(todoDTO.getTypeId());

        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setType(type);
        todo.setStatus(status);
        todo.setCreateDate(dateNow());

        return TodoMapper.INSTANCE.toDTO(todoRepository.save(todo));
    }

    @SneakyThrows
    public Todo get(Long id) {
        return todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
    }

    public TodoDTO update(TodoDTO todoDTO) {
        Todo todo = TodoMapper.INSTANCE.toEntity(todoDTO);
        todo.setUpdateDate(dateNow());
        return TodoMapper.INSTANCE.toDTO(todoRepository.save(todo));
    }

    public void close(Long id) {
        boolean isClosed = todoRepository.isClosed(id);
        if (!isClosed) todoRepository.close(id, dateNow());
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
