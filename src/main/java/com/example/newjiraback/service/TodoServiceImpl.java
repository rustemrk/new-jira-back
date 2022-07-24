package com.example.newjiraback.service;

import com.example.newjiraback.repository.TodoRepository;
import com.example.newjiraback.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public void create(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void update(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void delete(long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo get(long id) {
        Todo todo = null;
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            todo = optionalTodo.get();
        }
        return todo;
    }

    @Override
    public List<Todo> list() {
        return todoRepository.findAll();
    }
}
