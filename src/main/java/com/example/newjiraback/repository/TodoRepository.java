package com.example.newjiraback.repository;

import com.example.newjiraback.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query(value = "select cast(case when close_date is not null " +
            "then 1 " +
            "else 0 " +
            "end as bit) " +
            "from todo where id = :id", nativeQuery = true)
    boolean isClosed(Long id);

    @Query(value = "select * from Todo where status = :statusId order by kanban_order nulls first", nativeQuery = true)
    List<Todo> getTodosByStatusId(Long statusId);

}
