package com.example.stepik.repository;

import com.example.stepik.model.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TaskRepository extends PagingAndSortingRepository<Task,Long> {

    @Modifying
    @Query("UPDATE Task t SET t.done = TRUE WHERE t.id = :id")
    void markTaskAsDone(@Param("id") Long taskId);
}
