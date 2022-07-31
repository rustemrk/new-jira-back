package com.example.newjiraback.service;

import com.example.newjiraback.entity.Todo;
import com.example.newjiraback.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.newjiraback.util.DateUtil.dateNow;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public void create(Todo todo) {
        todo.setCreateDate(dateNow());
        todo.setClosed(false);
        todoRepository.save(todo);
    }

    @Override
    public void update(Todo todo) {
        todo.setUpdateDate(dateNow());
        todoRepository.save(todo);
    }

    @Override
    public void close(long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();

            if (!todo.isClosed()) {
                todo.setUpdateDate(dateNow());
                todo.setCloseDate(dateNow());
                todo.setClosed(true);
                todoRepository.save(todo);
            }
        }
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
