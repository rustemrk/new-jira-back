package com.example.newjiraback.service;

import com.example.newjiraback.entity.Todo;

import java.util.List;

public interface TodoService {
    public void save(Todo todo);
    public void update(Todo todo);
    public void delete(long id);
    public Todo get(long id);
    public List<Todo> list();
}
