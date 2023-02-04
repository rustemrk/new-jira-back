package com.example.newjiraback.service;

import com.example.newjiraback.model.TodoType;
import com.example.newjiraback.repository.TodoTypeRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.newjiraback.util.DateUtil.dateNow;

@Service
public class TodoTypeService {

    @Autowired
    private TodoTypeRepository todoTypeRepository;

    public TodoType create(TodoType todoType) {
        todoType.setCreateDate(dateNow());
        return todoTypeRepository.save(todoType);
    }

    @SneakyThrows
    public TodoType get(Long id) {
        return todoTypeRepository.findById(id).orElse(null);
    }

    public TodoType update(TodoType todoType) {
        return todoTypeRepository.save(todoType);
    }

    public void delete(Long id) {
        todoTypeRepository.deleteById(id);
    }
}
