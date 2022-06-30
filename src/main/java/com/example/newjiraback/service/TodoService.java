package com.example.newjiraback.service;

import com.example.newjiraback.entity.Todo;

import java.util.List;

public interface TodoService {
    public void save(Todo todo);
    public void update(Todo todo);
    public void delete(int id);
    public Todo get(int id);
    public List<Todo> list();
}
