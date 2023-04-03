package com.example.todo.service.implementation;

import com.example.todo.dto.TaskRequestDto;
import com.example.todo.dto.TaskResponseDto;
import com.example.todo.entity.TodoTask;
import com.example.todo.repository.TaskRepo;
import com.example.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;

    @Override
    public TaskResponseDto createTask(TaskRequestDto requestDto) {
        TodoTask task = TodoTask.builder()
                .name(requestDto.getName())
                        .description(requestDto.getDescription())
                                .status(requestDto.getStatus())
                                        .start(LocalDateTime.now())
                                                .build();

        TodoTask savedTask = taskRepo.save(task);

        return mapToDto(savedTask);
    }

    @Override
    public List<TaskResponseDto> getAllTask() {
        List<TodoTask> allTask = taskRepo.findAll();
        return allTask.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public TaskResponseDto mapToDto(TodoTask task) {
        return TaskResponseDto.builder()
                .status(task.getStatus())
                .description(task.getDescription())
                .name(task.getName()).build();
    }

}
