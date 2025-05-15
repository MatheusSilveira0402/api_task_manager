package com.example.api_task_manager.modules.tasks.repository;

import com.example.api_task_manager.modules.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}