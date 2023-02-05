package com.example.newjiraback.controller;

import com.example.newjiraback.dto.TodoDTO;
import com.example.newjiraback.model.Todo;
import com.example.newjiraback.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public TodoDTO create(@Valid @RequestBody TodoDTO todoDTO) {
        return todoService.create(todoDTO);
    }

    @PutMapping
    public TodoDTO update(@Valid @RequestBody TodoDTO todoDTO) {
        return todoService.update(todoDTO);
    }

    @PutMapping("/{id}")
    public HttpStatus close(@PathVariable Long id) {
        todoService.close(id);
        return HttpStatus.OK;
    }

    @GetMapping("/{id}")
    public Todo get(@PathVariable Long id) {
        return todoService.get(id);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        todoService.delete(id);
        return HttpStatus.OK;
    }
}