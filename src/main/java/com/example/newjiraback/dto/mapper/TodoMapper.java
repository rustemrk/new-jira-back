package com.example.newjiraback.dto.mapper;

import com.example.newjiraback.dto.TodoDTO;
import com.example.newjiraback.entity.Todo;
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
    @Mapping(source = "createDate", target = "createDate")
    @Mapping(source = "updateDate", target = "updateDate")
    @Mapping(source = "closeDate", target = "closeDate")
    @Mapping(source = "status.id", target = "statusId")
    @Mapping(source = "status.name", target = "statusName")
    @Mapping(source = "status.isSystem", target = "statusIsSystem")
    TodoDTO toDTO(Todo todo);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "typeId", target = "type.id")
    @Mapping(source = "typeName", target = "type.name")
    @Mapping(source = "typeIsSystem", target = "type.isSystem")
    @Mapping(source = "createDate", target = "createDate")
    @Mapping(source = "updateDate", target = "updateDate")
    @Mapping(source = "closeDate", target = "closeDate")
    @Mapping(source = "statusId", target = "status.id")
    @Mapping(source = "statusName", target = "status.name")
    @Mapping(source = "statusIsSystem", target = "status.isSystem")
    Todo toEntity(TodoDTO todoDTO);
}
