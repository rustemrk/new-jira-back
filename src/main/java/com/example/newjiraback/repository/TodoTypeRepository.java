package com.example.newjiraback.repository;

import com.example.newjiraback.model.TodoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoTypeRepository extends JpaRepository<TodoType, Long> {

}
