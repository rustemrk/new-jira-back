package com.example.newjiraback.dto.todo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoUpdateDTO {

    @NotNull
    private Long id;

    @NotBlank(message = "Заполните заголовок задачи")
    private String title;

    @NotNull
    private String description;

    @NotNull
    @Min(value = 1, message = "Выберите тип задачи")
    private Long typeId;

    @NotNull(message = "Выберите статус задачи")
    @Min(value = 1, message = "Выберите статус задачи")
    private Long statusId;
}
