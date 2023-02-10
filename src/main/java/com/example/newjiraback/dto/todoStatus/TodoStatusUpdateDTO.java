package com.example.newjiraback.dto.todoStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoStatusUpdateDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String name;
}
