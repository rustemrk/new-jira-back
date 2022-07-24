package com.example.newjiraback.controller;

import com.example.newjiraback.entity.Todo;
import com.example.newjiraback.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/save")
    public Todo create(@RequestBody Todo todo) {
        todoService.create(todo);
        return todo;
    }

    @PutMapping("/update")
    public Todo update(@RequestBody Todo todo) {
        todoService.update(todo);
        return todo;
    }

    @GetMapping("/get/{id}")
    public Todo get(@PathVariable long id) {
        return todoService.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        todoService.delete(id);
    }

    @GetMapping("/list")
    public List<Todo> list() {
        return todoService.list();
    }
}