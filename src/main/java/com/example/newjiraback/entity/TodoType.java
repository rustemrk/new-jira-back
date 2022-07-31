package com.example.newjiraback.entity;

import javax.persistence.*;

@Entity
@Table(name = "todo_type")
public class TodoType {

    public static final int TASK = 1;
    public static final int BUG = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public TodoType() {
    }

    public TodoType(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
