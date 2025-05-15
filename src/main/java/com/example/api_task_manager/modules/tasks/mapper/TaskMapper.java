package com.example.api_task_manager.modules.tasks.mapper;

import com.example.api_task_manager.modules.tasks.dto.TaskDto;
import com.example.api_task_manager.modules.tasks.model.Task;

public class TaskMapper {

    public static TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getUserId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getScheduledAt(),
                task.getCompletedAt(),
                task.getCreatedAt()
        );
    }

    public static Task toEntity(TaskDto dto) {
        Task task = new Task();
        task.setId(dto.id());
        task.setUserId(dto.userId());
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setStatus(dto.status());
        task.setPriority(dto.priority());
        task.setScheduledAt(dto.scheduledAt());
        task.setCompletedAt(dto.completedAt());
        task.setCreatedAt(dto.createdAt());
        return task;
    }
}