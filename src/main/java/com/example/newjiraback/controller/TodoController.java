package com.example.newjiraback.controller;

import com.example.newjiraback.dto.todo.TodoCreateDTO;
import com.example.newjiraback.dto.todo.TodoDTO;
import com.example.newjiraback.dto.todo.TodoUpdateDTO;
import com.example.newjiraback.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody TodoCreateDTO todoCreateDTO) throws Exception {
        todoService.create(todoCreateDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@Valid @RequestBody TodoUpdateDTO todoUpdateDTO) throws Exception {
        todoService.update(todoUpdateDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> get(@PathVariable Long id) throws Exception {
        TodoDTO todoDTO = todoService.get(id);
        return ResponseEntity.ok().body(todoDTO);
    }
}