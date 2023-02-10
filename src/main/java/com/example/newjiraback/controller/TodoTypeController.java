package com.example.newjiraback.controller;

import com.example.newjiraback.model.TodoType;
import com.example.newjiraback.service.TodoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo-type")
public class TodoTypeController {
    @Autowired
    private TodoTypeService todoTypeService;

    @PostMapping
    public TodoType create(@RequestBody TodoType todoType) {
        return todoTypeService.create(todoType);
    }

    @PutMapping
    public TodoType save(@RequestBody TodoType todoType) {
        return todoTypeService.update(todoType);
    }

    @GetMapping("/{id}")
    public TodoType get(@PathVariable Long id) {
        return todoTypeService.get(id);
    }

    @GetMapping
    public List<TodoType> list() {
        return todoTypeService.list();
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        todoTypeService.delete(id);
        return HttpStatus.OK;
    }
}
