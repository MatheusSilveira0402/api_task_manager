package com.example.api_task_manager.modules.tasks.service;

import org.springframework.stereotype.Service;

import com.example.api_task_manager.modules.tasks.dto.TaskDto;
import com.example.api_task_manager.modules.tasks.mapper.TaskMapper;
import com.example.api_task_manager.modules.tasks.repository.TaskRepository;

import com.example.api_task_manager.modules.tasks.repository.TaskRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskDto> getAll() {
        return repository.findAll().stream()
                .map(TaskMapper::toDto)
                .toList();
    }

    public TaskDto getById(UUID id) {
        return repository.findById(id)
                .map(TaskMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public TaskDto create(TaskDto dto) {
        return TaskMapper.toDto(repository.save(TaskMapper.toEntity(dto)));
    }
}