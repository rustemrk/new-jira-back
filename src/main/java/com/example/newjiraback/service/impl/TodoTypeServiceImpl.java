package com.example.newjiraback.service.impl;

import com.example.newjiraback.dto.TodoType.TodoTypeCreateDTO;
import com.example.newjiraback.dto.TodoType.TodoTypeDTO;
import com.example.newjiraback.dto.TodoType.TodoTypeUpdateDTO;
import com.example.newjiraback.dto.mapper.TodoTypeMapper;
import com.example.newjiraback.exception.ResourceNotFoundException;
import com.example.newjiraback.model.TodoType;
import com.example.newjiraback.repository.TodoTypeRepository;
import com.example.newjiraback.service.TodoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.newjiraback.util.DateUtil.dateNow;

@Service
public class TodoTypeServiceImpl implements TodoTypeService {

    @Autowired
    private TodoTypeRepository todoTypeRepository;

    @Override
    public Long create(TodoTypeCreateDTO todoTypeCreateDTO) {
        TodoType todoType = TodoType.builder()
                .name(todoTypeCreateDTO.getName())
                .isSystem(false)
                .createDate(dateNow())
                .icon(todoTypeCreateDTO.getIcon())
                .color(todoTypeCreateDTO.getColor())
                .build();
        return todoTypeRepository.save(todoType).getId();
    }

    @Override
    public void update(TodoTypeUpdateDTO todoTypeUpdateDTO) {
        TodoType todoType = todoTypeRepository
                .findById(todoTypeUpdateDTO.getId())
                .orElseThrow(ResourceNotFoundException::new);

        todoType.setName(todoTypeUpdateDTO.getName());
        todoType.setIcon(todoTypeUpdateDTO.getIcon());
        todoType.setColor(todoTypeUpdateDTO.getColor());

        todoTypeRepository.save(todoType);
    }

    @Override
    public TodoType get(Long id) {
        return todoTypeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<TodoTypeDTO> getALL() {
        List<TodoType> todoTypeList = todoTypeRepository.findAll();
        List<TodoTypeDTO> todoTypeDTOList = new ArrayList<>();

        for (TodoType type : todoTypeList) {
            todoTypeDTOList.add(TodoTypeMapper.INSTANCE.toDTO(type));
        }

        return todoTypeDTOList;
    }
}
