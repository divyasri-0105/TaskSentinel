package com.tasksentinel.repository;

import com.tasksentinel.entity.Task;
import com.tasksentinel.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByReminderDate(LocalDate reminderDate);

}