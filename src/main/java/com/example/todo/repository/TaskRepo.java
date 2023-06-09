package com.example.todo.repository;

import com.example.todo.entity.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<TodoTask, Long> {
}
