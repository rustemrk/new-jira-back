package com.example.newjiraback.dto;

import lombok.*;

import java.util.Map;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilterRequestBody {
    private Map<String, Object> filter;
}
