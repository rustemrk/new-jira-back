package com.example.newjiraback.controller;

import com.example.newjiraback.entity.Task;
import com.example.newjiraback.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/save")
    public Task save(@RequestBody Task task) {
        taskService.save(task);
        return task;
    }

    @PutMapping("/update")
    public Task update(@RequestBody Task task) {
        taskService.save(task);
        return task;
    }

    @GetMapping("/get/{id}")
    public Task get(@PathVariable int id) {
        return taskService.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        taskService.delete(id);
    }

    @GetMapping("/list")
    public List<Task> list() {
        return taskService.list();
    }
}