package com.example.todo.entity;

//Your task:

//        Create a simple functional TODO List Application
 //       Create a To-do with the following parameters (Task Id, Task name, Task Date,Task Status)
 //       List the To-dos that was created.
  //      Viewing of a To-do list


   //     Version Control
     //   Create a public repo
     //   Push code on the repo
   //     Share requisite URLs on chat

import com.example.todo.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", nullable = false)
    private Long taskId;

    private String name;
    private String description;
    private Status status;
    @CreationTimestamp
    private LocalDateTime start;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
