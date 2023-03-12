package com.example.newjiraback.dto.TodoType;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoTypeUpdateDTO {
    @NotNull
    private Long id;
    @NotBlank(message = "Заполните название типа")
    private String name;
    private String icon;
    private String color;
}
