package com.example.newjiraback.dto.mapper;

import com.example.newjiraback.dto.TodoDTO;
import com.example.newjiraback.model.Todo;
import com.example.newjiraback.service.TodoStatusService;
import com.example.newjiraback.service.TodoTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.newjiraback.util.DateUtil.dateNow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TodoMapperTest {

    @Autowired
    private TodoTypeService todoTypeService;

    @Autowired
    private TodoStatusService todoStatusService;

    Todo createTodo() {
        return Todo.builder()
                .id(1L)
                .title("Test")
                .description("Checking todo")
                .type(todoTypeService.get(2L))
                .createDate(dateNow())
                .updateDate(dateNow())
                .closeDate(dateNow())
                .status(todoStatusService.get(2L))
                .build();
    }

    TodoDTO createTodoDTO() {
        return TodoDTO.builder()
                .id(1L)
                .title("Test")
                .description("Checking todo")
                .typeId(2L)
                .typeName("Баг")
                .typeIsSystem(true)
                .createDate(dateNow())
                .updateDate(dateNow())
                .closeDate(dateNow())
                .statusName("In progress")
                .statusIsSystem(true)
                .build();
    }

    @Test
    void toDTO() {
        Todo todo = createTodo();
        TodoDTO todoDTO = TodoMapper.INSTANCE.toDTO(todo);
        System.out.println(todoDTO);
        assertEquals(todoDTO.getTypeId(), todo.getType().getId());
    }

    @Test
    void toEntity() {
        TodoDTO todoDTO = createTodoDTO();
        Todo todo = TodoMapper.INSTANCE.toEntity(todoDTO);
        assertEquals(todo.getType().getId(), todoDTO.getTypeId());
    }
}