package com.example.newjiraback.dto.TodoType;

import lombok.*;

import java.time.OffsetDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoTypeDTO {
    private Long id;
    private String name;
    private Boolean isSystem;
    private OffsetDateTime createDate;
    private String icon;
    private String color;
}
