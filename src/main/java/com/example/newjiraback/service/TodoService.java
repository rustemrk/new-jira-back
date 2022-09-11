package com.example.newjiraback.service;

import com.example.newjiraback.entity.Todo;
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

    public Todo create(Todo todo) {
        todo.setCreateDate(dateNow());
        return todoRepository.save(todo);
    }

    @SneakyThrows
    public Todo get(Long id) {
        return todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
    }

    public Todo update(Todo todo) {
        todo.setUpdateDate(dateNow());
        return todoRepository.save(todo);
    }

    public void close(Long id) {
        boolean isClosed = todoRepository.isClosed(id);
        if (!isClosed) todoRepository.close(id, dateNow());
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
