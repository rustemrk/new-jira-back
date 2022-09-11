package com.example.newjiraback.controller;

import com.example.newjiraback.entity.TodoType;
import com.example.newjiraback.service.TodoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/todo-type")
public class TodoTypeController {

    @Autowired
    private TodoTypeService todoTypeService;

    @PutMapping("/save")
    public TodoType save(@Valid @RequestBody TodoType todoType) {
        if (isEmpty(todoType.getId())) {
            return todoTypeService.create(todoType);
        } else {
            return todoTypeService.update(todoType);
        }
    }

    @GetMapping("/get/{id}")
    public TodoType get(@PathVariable Long id) {
        return todoTypeService.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        todoTypeService.delete(id);
        return HttpStatus.OK;
    }
}
