package com.tasksentinel.service;

import com.tasksentinel.entity.Task;
import com.tasksentinel.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> getTodayTasks() {
        return taskRepository.findByReminderDate(LocalDate.now());
    }

    public Task updateTask(Long id, Task updatedTask) {

        Task existingTask = taskRepository.findById(id).orElse(null);

        if (existingTask == null) {
            return null;
        }

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setReminderDate(updatedTask.getReminderDate());
        existingTask.setReminderTime(updatedTask.getReminderTime());
        existingTask.setCompletionDate(updatedTask.getCompletionDate());
        existingTask.setCategory(updatedTask.getCategory());
        existingTask.setRemindersPerDay(updatedTask.getRemindersPerDay());
        existingTask.setStatus(updatedTask.getStatus());

        return taskRepository.save(existingTask);
    }

    public boolean deleteTask(Long id) {

        if (!taskRepository.existsById(id)) {
            return false;
        }

        taskRepository.deleteById(id);
        return true;
    }

}