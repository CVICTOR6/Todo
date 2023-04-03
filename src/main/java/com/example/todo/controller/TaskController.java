package com.example.todo.controller;

import com.example.todo.dto.TaskRequestDto;
import com.example.todo.dto.TaskResponseDto;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createTask(@RequestBody TaskRequestDto requestDto) {
        TaskResponseDto task = taskService.createTask(requestDto);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> ViewAllTask() {
        List<TaskResponseDto> tasks = taskService.getAllTask();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
