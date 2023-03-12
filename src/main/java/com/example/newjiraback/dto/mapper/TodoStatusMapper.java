package com.example.newjiraback.dto.mapper;

import com.example.newjiraback.dto.todoStatus.TodoStatusDTO;
import com.example.newjiraback.dto.todoStatus.TodoStatusWithTodosDTO;
import com.example.newjiraback.model.TodoStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoStatusMapper {
    TodoStatusMapper INSTANCE = Mappers.getMapper(TodoStatusMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "isSystem", target = "isSystem")
    @Mapping(source = "createDate", target = "createDate")
    TodoStatusDTO toDTO(TodoStatus todoStatus);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "isSystem", target = "isSystem")
    @Mapping(source = "createDate", target = "createDate")
    TodoStatusWithTodosDTO toDTOWithTodos(TodoStatus todoStatus);
}
