package com.example.newjiraback.service;

import com.example.newjiraback.model.TodoStatus;
import com.example.newjiraback.repository.TodoStatusRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.newjiraback.util.DateUtil.dateNow;

@Service
public class TodoStatusService {

    @Autowired
    private TodoStatusRepository todoStatusRepository;

    public TodoStatus create(TodoStatus todoStatus) {
        todoStatus.setCreateDate(dateNow());
        return todoStatusRepository.save(todoStatus);
    }

    @SneakyThrows
    public TodoStatus get(Long id) {
        return todoStatusRepository.findById(id).orElse(null);
    }

    public TodoStatus update(TodoStatus todoStatus) {
        return todoStatusRepository.save(todoStatus);
    }

    public void delete(Long id) {
        todoStatusRepository.delete(id);
    }

    public List<TodoStatus> list() {
        return todoStatusRepository.findAll();
    }
}
