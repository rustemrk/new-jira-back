package com.example.newjiraback.service;

import com.example.newjiraback.entity.Task;

import java.util.List;

public interface TaskService {
    public void save(Task task);
    public void update(Task task);
    public void delete(int id);
    public Task get(int id);
    public List<Task> list();
}
