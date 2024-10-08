package com.example.newjiraback.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_todo")
    @SequenceGenerator(name = "seq_todo", allocationSize = 1, initialValue = 1000)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotBlank
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private TodoType type;

    @Column(name = "create_date")
    private OffsetDateTime createDate;

    @Column(name = "update_date")
    private OffsetDateTime updateDate;

    @Column(name = "close_date")
    private OffsetDateTime closeDate;

    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    private TodoStatus status;

    @Column(name = "kanban_order")
    private Long kanbanOrder;

}
