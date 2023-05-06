package com.example.newjiraback.controller;

import com.example.newjiraback.dto.todo.TodoCreateDTO;
import com.example.newjiraback.dto.todo.TodoDTO;
import com.example.newjiraback.dto.todo.TodoKanbanOrderDTO;
import com.example.newjiraback.dto.todo.TodoUpdateDTO;
import com.example.newjiraback.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody TodoCreateDTO todoCreateDTO) {
        Long id = todoService.create(todoCreateDTO);
        return ResponseEntity.ok().body(id);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@Valid @RequestBody TodoUpdateDTO todoUpdateDTO) {
        todoService.update(todoUpdateDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> get(@PathVariable Long id) {
        TodoDTO todoDTO = todoService.get(id);
        return ResponseEntity.ok().body(todoDTO);
    }

    @PatchMapping("/save-kanban-order")
    public ResponseEntity<HttpStatus> saveKanbanOrder(@Valid @RequestBody List<TodoKanbanOrderDTO> kanbanOrderDTOList) {
        todoService.saveKanbanOrder(kanbanOrderDTOList);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}