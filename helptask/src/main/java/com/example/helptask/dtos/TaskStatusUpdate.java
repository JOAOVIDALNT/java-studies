package com.example.helptask.dtos;

import com.example.helptask.enums.TaskStatusEnum;

public class TaskStatusUpdate {

    private TaskStatusEnum status;

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }
}
