package com.example.helptask.models;

import com.example.helptask.enums.ProblemStatusEnum;
import com.example.helptask.enums.TaskStatusEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ProblemStatusEnum problem;
    private String description;
    private TaskStatusEnum status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public ProblemStatusEnum getProblem() {
        return problem;
    }

    public void setProblem(ProblemStatusEnum problem) {
        this.problem = problem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }
}
