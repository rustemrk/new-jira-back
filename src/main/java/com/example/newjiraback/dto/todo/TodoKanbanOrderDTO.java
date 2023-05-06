package com.example.newjiraback.dto.todo;

import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoKanbanOrderDTO {

    @NotNull
    private Long todoId;
    @NotNull
    private Long statusId;

    private Long kanbanOrder;
}
