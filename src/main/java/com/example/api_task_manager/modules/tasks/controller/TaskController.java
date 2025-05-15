package com.example.api_task_manager.modules.tasks.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import com.example.api_task_manager.modules.tasks.dto.TaskDto;
import com.example.api_task_manager.modules.tasks.service.TaskService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tarefas")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<TaskDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public TaskDto create(@RequestBody TaskDto dto) {
        return service.create(dto);
    }
}