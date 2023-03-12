package com.example.newjiraback.dto.TodoType;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoTypeCreateDTO {

    @NotBlank(message = "Заполните название типа")
    private String name;
    private String icon;
    private String color;
}
