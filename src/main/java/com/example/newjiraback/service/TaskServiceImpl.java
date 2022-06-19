package com.example.newjiraback.service;

import com.example.newjiraback.dao.TaskRepository;
import com.example.newjiraback.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void update(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void delete(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task get(int id) {
        Task task = null;
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            task = optionalTask.get();
        }
        return task;
    }

    @Override
    public List<Task> list() {
        return taskRepository.findAll();
    }
}
