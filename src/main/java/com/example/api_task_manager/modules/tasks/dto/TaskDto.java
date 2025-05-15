package com.example.api_task_manager.modules.tasks.dto;



import java.time.LocalDateTime;
import java.util.UUID;

import com.example.api_task_manager.modules.tasks.model.enums.TaskPriority;
import com.example.api_task_manager.modules.tasks.model.enums.TaskStatus;


public record TaskDto(
    UUID id,
    UUID userId,
    String title,
    String description,
    TaskStatus status,
    TaskPriority priority,
    LocalDateTime scheduledAt,
    LocalDateTime completedAt,
    LocalDateTime createdAt
) {}