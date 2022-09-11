package com.example.newjiraback.controller;

import com.example.newjiraback.entity.TodoStatus;
import com.example.newjiraback.service.TodoStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/todo-status")
public class TodoStatusController {

    @Autowired
    private TodoStatusService todoStatusService;

    @PutMapping("/save")
    public TodoStatus save(@Valid @RequestBody TodoStatus todoStatus) {
        if (isEmpty(todoStatus.getId())) {
            return todoStatusService.create(todoStatus);
        } else {
            return todoStatusService.update(todoStatus);
        }
    }

    @GetMapping("/get/{id}")
    public TodoStatus get(@PathVariable Long id) {
        return todoStatusService.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        todoStatusService.delete(id);
        return HttpStatus.OK;
    }
}
