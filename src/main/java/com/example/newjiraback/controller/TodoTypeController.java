package com.example.newjiraback.controller;

import com.example.newjiraback.dto.TodoType.TodoTypeCreateDTO;
import com.example.newjiraback.dto.TodoType.TodoTypeDTO;
import com.example.newjiraback.dto.TodoType.TodoTypeUpdateDTO;
import com.example.newjiraback.model.TodoType;
import com.example.newjiraback.service.TodoTypeService;
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
    private TodoTypeService todoTypeService;

    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody TodoTypeCreateDTO todoTypeCreateDTO) {
        Long id = todoTypeService.create(todoTypeCreateDTO);
        return ResponseEntity.ok().body(id);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@Valid @RequestBody TodoTypeUpdateDTO todoTypeUpdateDTO) {
        todoTypeService.update(todoTypeUpdateDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoType> get(@PathVariable Long id) {
        TodoType todoType = todoTypeService.get(id);
        return ResponseEntity.ok().body(todoType);
    }

    @GetMapping
    public ResponseEntity<List<TodoTypeDTO>> getAll() {
        return ResponseEntity.ok().body(todoTypeService.getALL());
    }
}
