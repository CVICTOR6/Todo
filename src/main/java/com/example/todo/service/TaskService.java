package com.example.todo.service;

import com.example.todo.dto.TaskRequestDto;
import com.example.todo.dto.TaskResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    TaskResponseDto createTask(TaskRequestDto requestDto);

    List<TaskResponseDto> getAllTask();
}
