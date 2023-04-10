package com.example.helptask.services;

import com.example.helptask.dtos.TaskStatusUpdate;
import com.example.helptask.models.TaskModel;
import com.example.helptask.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<TaskModel> getAll() {
        return repository.findAll();
    }

    public TaskModel createTask(@Valid TaskModel task) {
        return repository.save(task);
    }

    public TaskModel getById(Long id) {
        Optional<TaskModel> entity = repository.findById(id);
        return entity.orElseThrow(() -> new RuntimeException()); // implementar uma exceção personalizada
    }

    public TaskModel updateStatus(Long id, TaskStatusUpdate task) {
        TaskModel entity = repository.findById(id).get();

        entity.setStatus(task.getStatus());

        return repository.save(entity);
    }
}
