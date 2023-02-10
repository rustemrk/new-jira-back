package com.example.newjiraback.dto.todo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private Long id;
    private String title;
    private String description;
    private Long typeId;
    private String typeName;
    private Boolean typeIsSystem;
    private OffsetDateTime createDate;
    private OffsetDateTime updateDate;
    private OffsetDateTime closeDate;
    private Long statusId;
    private String statusName;
    private Boolean statusIsSystem;
}
