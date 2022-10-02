package com.example.newjiraback.controller;

import com.example.newjiraback.dto.TodoDTO;
import com.example.newjiraback.entity.Todo;
import com.example.newjiraback.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PutMapping("/save")
    public TodoDTO save(@Valid @RequestBody TodoDTO todoDTO) {
        if (isEmpty(todoDTO.getId())) {
            return todoService.create(todoDTO);
        } else {
            return todoService.update(todoDTO);
        }
    }

    @PutMapping("/close/{id}")
    public HttpStatus close(@PathVariable Long id) {
        todoService.close(id);
        return HttpStatus.OK;
    }

    @GetMapping("/get/{id}")
    public Todo get(@PathVariable Long id) {
        return todoService.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        todoService.delete(id);
        return HttpStatus.OK;
    }
}