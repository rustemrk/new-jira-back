package com.example.newjiraback.controller;

import com.example.newjiraback.entity.Todo;
import com.example.newjiraback.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/create")
    public Todo create(@RequestBody Todo todo) {
        todoService.create(todo);
        return todo;
    }

    @PutMapping("/update")
    public Todo update(@RequestBody Todo todo) {
        todoService.update(todo);
        return todo;
    }

    @PutMapping("/close/{id}")
    public HttpStatus close(@PathVariable long id) {
        todoService.close(id);
        return HttpStatus.OK;
    }

    @GetMapping("/get/{id}")
    public Todo get(@PathVariable long id) {
        return todoService.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable long id) {
        todoService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/list")
    public List<Todo> list() {
        return todoService.list();
    }
}