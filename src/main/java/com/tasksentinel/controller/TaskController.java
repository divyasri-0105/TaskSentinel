package com.tasksentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @GetMapping("/tasks")
    public List<String> getTasks() {
        return List.of("Study DSA", "Go to Gym", "Drink Water");
    }

}