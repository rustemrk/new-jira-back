package com.example.newjiraback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private Long id;
    private String title;
    private String description;
    private Long type;
    private OffsetDateTime createDate;
    private OffsetDateTime updateDate;
    private OffsetDateTime closeDate;
}
