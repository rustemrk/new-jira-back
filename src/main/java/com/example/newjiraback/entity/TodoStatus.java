package com.example.newjiraback.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo_status")
public class TodoStatus {

    public static final long TO_DO = 1L;
    public static final long IN_PROGRESS = 2L;
    public static final long DONE = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_todo_status")
    @SequenceGenerator(name = "seq_todo_status", allocationSize = 1, initialValue = 1000)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_system")
    private Boolean isSystem;

    @Column(name = "create_date")
    private OffsetDateTime createDate;
}
