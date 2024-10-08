package com.example.newjiraback.dto.todoStatus;

import lombok.*;

import java.time.OffsetDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoStatusDTO {
    private Long id;
    private String name;
    private Boolean isSystem;
    private OffsetDateTime createDate;
}
