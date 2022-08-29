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
        todo.setIsClosed(false);
        return todoRepository.save(todo);
    }

    public Todo update(Todo todo) {
        todo.setUpdateDate(dateNow());
        return todoRepository.save(todo);
    }

    public void close(Long id) {
//        Todo todo = todoService.get(id);
//        if (todo != null && !todo.getClosed()) {
//            todo.setUpdateDate(dateNow());
//            todo.setCloseDate(dateNow());
//            todo.setClosed(true);
//            todoRepository.save(todo);
//        }
    }

    @SneakyThrows
    public Todo get(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(TodoNotFoundException::new);
    }
}
