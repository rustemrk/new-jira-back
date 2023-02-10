package com.example.newjiraback.service;

import com.example.newjiraback.dto.mapper.TodoStatusMapper;
import com.example.newjiraback.dto.todoStatus.TodoStatusCreateDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusUpdateDTO;
import com.example.newjiraback.model.Todo;
import com.example.newjiraback.model.TodoStatus;
import com.example.newjiraback.repository.TodoRepository;
import com.example.newjiraback.repository.TodoStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.newjiraback.util.DateUtil.dateNow;

@Service
public class TodoStatusService {
    @Autowired
    private TodoStatusRepository todoStatusRepository;
    @Autowired
    private TodoRepository todoRepository;

    public void create(TodoStatusCreateDTO todoStatusCreateDTO) {
        TodoStatus todoStatus = TodoStatus.builder()
                .name(todoStatusCreateDTO.getName())
                .createDate(dateNow())
                .build();
        todoStatusRepository.save(todoStatus);
    }

    public void update(TodoStatusUpdateDTO todoStatusUpdateDTO) throws Exception {
        TodoStatus todoStatus = todoStatusRepository
                .findById(todoStatusUpdateDTO.getId())
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        todoStatus.setName(todoStatusUpdateDTO.getName());
        todoStatusRepository.save(todoStatus);
    }

    public TodoStatus get(Long id) throws Exception {
        return todoStatusRepository
                .findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }


    public List<TodoStatus> getALL() {
        return todoStatusRepository.findAll();
    }

    public List<TodoStatusDTO> getAllWithTodos() {
        List<TodoStatus> todoStatusList = todoStatusRepository.findAll();
        List<TodoStatusDTO> todoStatusDTOList = new ArrayList<>();

        for (TodoStatus todoStatus : todoStatusList) {
            List<Todo> todoList = todoRepository.getTodosByStatus_Id(todoStatus.getId());
            TodoStatusDTO todoStatusDTO = TodoStatusMapper.INSTANCE.toDTO(todoStatus);
            todoStatusDTO.setTodos(todoList);
            todoStatusDTOList.add(todoStatusDTO);
        }

        return todoStatusDTOList;
    }
}
