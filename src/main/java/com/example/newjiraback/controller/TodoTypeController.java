package com.example.newjiraback.controller;

import com.example.newjiraback.dto.TodoType.TodoTypeCreateDTO;
import com.example.newjiraback.dto.TodoType.TodoTypeDTO;
import com.example.newjiraback.dto.TodoType.TodoTypeUpdateDTO;
import com.example.newjiraback.model.TodoType;
import com.example.newjiraback.service.TodoTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todo-type")
public class TodoTypeController {
    @Autowired
    private TodoTypeServiceImpl todoTypeServiceImpl;

    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody TodoTypeCreateDTO todoTypeCreateDTO) {
        Long id = todoTypeServiceImpl.create(todoTypeCreateDTO);
        return ResponseEntity.ok().body(id);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@Valid @RequestBody TodoTypeUpdateDTO todoTypeUpdateDTO) {
        todoTypeServiceImpl.update(todoTypeUpdateDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoType> get(@PathVariable Long id) {
        TodoType todoType = todoTypeServiceImpl.get(id);
        return ResponseEntity.ok().body(todoType);
    }

    @GetMapping
    public ResponseEntity<List<TodoTypeDTO>> getAll() {
        return ResponseEntity.ok().body(todoTypeServiceImpl.getALL());
    }
}
