package com.tasksentinel.entity;

import com.tasksentinel.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    private LocalDate reminderDate;

    private LocalTime reminderTime;

    private LocalDate completionDate;

    private String category;

    private Integer remindersPerDay;

    @Enumerated(EnumType.STRING)
    private Status status;

}