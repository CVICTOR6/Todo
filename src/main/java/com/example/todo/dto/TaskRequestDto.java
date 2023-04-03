package com.example.todo.dto;

import com.example.todo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRequestDto {
    private String name;
    private String description;
    private Status status;
    @CreationTimestamp
    private LocalDateTime start;
}
