package com.example.newjiraback.repository;

import com.example.newjiraback.model.TodoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoStatusRepository extends JpaRepository<TodoStatus, Long> {

}
