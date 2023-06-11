package com.example.newjiraback.repository;

import com.example.newjiraback.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BoardRepository extends JpaRepository<Todo, Long> {

    @Modifying
    @Transactional
    @Query(value = "update Todo " +
            "set status = :statusId, " +
            "kanban_order = :kanbanOrder " +
            "where id = :todoId", nativeQuery = true)
    void saveOrder(long todoId, long statusId, long kanbanOrder);
}
