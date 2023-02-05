package com.example.newjiraback.controller;

import com.example.newjiraback.model.TodoStatus;
import com.example.newjiraback.service.TodoStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/todo-status")
public class TodoStatusController {
    @Autowired
    private TodoStatusService todoStatusService;

    @PostMapping
    public TodoStatus create(@Valid @RequestBody TodoStatus todoStatus) {
        return todoStatusService.create(todoStatus);
    }

    @PutMapping
    public TodoStatus update(@Valid @RequestBody TodoStatus todoStatus) {
        return todoStatusService.update(todoStatus);

    }

    @GetMapping("/{id}")
    public TodoStatus get(@PathVariable Long id) {
        return todoStatusService.get(id);
    }

    @GetMapping
    public List<TodoStatus> list() {
        return todoStatusService.list();
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        todoStatusService.delete(id);
        return HttpStatus.OK;
    }
}
