package com.example.newjiraback.model;

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
@Table(name = "todo_type")
public class TodoType {

    public static final Long TASK = 1L;
    public static final Long BUG = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_todo_type")
    @SequenceGenerator(name = "seq_todo_type", allocationSize = 1, initialValue = 1000)
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
