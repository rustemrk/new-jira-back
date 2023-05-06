package com.example.newjiraback.dto.mapper;

import com.example.newjiraback.dto.todo.TodoDTO;
import com.example.newjiraback.model.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoMapper {
    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "type.id", target = "typeId")
    @Mapping(source = "type.name", target = "typeName")
    @Mapping(source = "type.isSystem", target = "typeIsSystem")
    @Mapping(source = "type.icon", target = "typeIcon")
    @Mapping(source = "type.color", target = "typeColor")
    @Mapping(source = "createDate", target = "createDate")
    @Mapping(source = "updateDate", target = "updateDate")
    @Mapping(source = "closeDate", target = "closeDate")
    @Mapping(source = "status.id", target = "statusId")
    @Mapping(source = "status.name", target = "statusName")
    @Mapping(source = "status.isSystem", target = "statusIsSystem")
    @Mapping(source = "kanbanOrder", target = "kanbanOrder")
    TodoDTO toDTO(Todo todo);

}
