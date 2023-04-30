package com.example.newjiraback.dto.todoStatus;

import com.example.newjiraback.dto.todo.TodoDTO;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoStatusWithTodosDTO {
    private Long id;
    private String name;
    private Boolean isSystem;
    private OffsetDateTime createDate;
    private List<TodoDTO> todos;
}
