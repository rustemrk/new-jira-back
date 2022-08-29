package com.example.newjiraback.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
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
    @OneToOne
    @JoinColumn(name = "type", nullable = false)
    private TodoType type;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "close_date")
    private LocalDateTime closeDate;

    @Column(name = "is_closed")
    private Boolean isClosed;

}
