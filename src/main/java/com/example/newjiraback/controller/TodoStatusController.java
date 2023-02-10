package com.example.newjiraback.controller;

import com.example.newjiraback.dto.todoStatus.TodoStatusCreateDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusUpdateDTO;
import com.example.newjiraback.model.TodoStatus;
import com.example.newjiraback.service.TodoStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo-status")
public class TodoStatusController {
    @Autowired
    private TodoStatusService todoStatusService;

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody TodoStatusCreateDTO todoStatusCreateDTO) {
        todoStatusService.create(todoStatusCreateDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestBody TodoStatusUpdateDTO todoStatusUpdateDTO) throws Exception {
        todoStatusService.update(todoStatusUpdateDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoStatus> get(@PathVariable Long id) throws Exception {
        TodoStatus todoStatus = todoStatusService.get(id);
        return ResponseEntity.ok().body(todoStatus);
    }

    @GetMapping
    public List<TodoStatus> getAll() {
        return todoStatusService.getALL();
    }

    @GetMapping("/with-todos")
    public List<TodoStatusDTO> getAllWithTodos() {
        return todoStatusService.getAllWithTodos();
    }
}
