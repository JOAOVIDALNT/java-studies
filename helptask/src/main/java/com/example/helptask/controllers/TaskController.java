package com.example.helptask.controllers;

import com.example.helptask.models.TaskModel;
import com.example.helptask.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {



    @Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<List<TaskModel>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }




}
