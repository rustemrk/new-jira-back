package com.example.newjiraback.dto.mapper;

import com.example.newjiraback.dto.TodoType.TodoTypeDTO;
import com.example.newjiraback.model.TodoType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoTypeMapper {
    TodoTypeMapper INSTANCE = Mappers.getMapper(TodoTypeMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "isSystem", target = "isSystem")
    @Mapping(source = "createDate", target = "createDate")
    @Mapping(source = "icon", target = "icon")
    @Mapping(source = "color", target = "color")
    TodoTypeDTO toDTO(TodoType todoType);
}
