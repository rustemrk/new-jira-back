package com.example.newjiraback.controller;

import com.example.newjiraback.dto.todoStatus.TodoStatusCreateDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusUpdateDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusWithTodosDTO;
import com.example.newjiraback.model.TodoStatus;
import com.example.newjiraback.service.TodoStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todo-status")
public class TodoStatusController {
    @Autowired
    private TodoStatusService todoStatusService;

    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody TodoStatusCreateDTO todoStatusCreateDTO) {
        Long id = todoStatusService.create(todoStatusCreateDTO);
        return ResponseEntity.ok().body(id);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@Valid @RequestBody TodoStatusUpdateDTO todoStatusUpdateDTO) {
        todoStatusService.update(todoStatusUpdateDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoStatus> get(@PathVariable Long id) {
        TodoStatus todoStatus = todoStatusService.get(id);
        return ResponseEntity.ok().body(todoStatus);
    }

    @GetMapping
    public ResponseEntity<List<TodoStatusDTO>> getAll() {
        return ResponseEntity.ok().body(todoStatusService.getALL());
    }

    @GetMapping("/with-todos")
    public ResponseEntity<List<TodoStatusWithTodosDTO>> getAllWithTodos() {
        return ResponseEntity.ok().body(todoStatusService.getAllWithTodos());
    }
}
