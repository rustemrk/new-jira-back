package com.example.newjiraback.repository;

import com.example.newjiraback.entity.TodoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoStatusRepository extends JpaRepository<TodoStatus, Long> {

    @Query("delete from TodoStatus where id = :id and isSystem = false")
    void delete(@Param("id") Long id);

}
