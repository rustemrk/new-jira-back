package com.example.newjiraback.repository;

import com.example.newjiraback.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query(value = "select cast(case when close_date is not null then 1 else 0 end as bit) " +
            "from todo where id = :id", nativeQuery = true)
    boolean isClosed(Long id);

    @Modifying
    @Transactional
    @Query("update Todo set closeDate = :dateNow where id = :id")
    void close(Long id, OffsetDateTime dateNow);

}
