package com.example.stepik.controller;

import com.example.stepik.model.Task;
import com.example.stepik.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TaskController {

    private final TaskRepository taskRepository;
    @Autowired
    private TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public Iterable<Task> getAll() {
        return taskRepository.findAll();
    }
    @GetMapping("/tasks/{id}")
    public Optional getById(@PathVariable Long id) {
        return taskRepository.findById(id);
    }

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return taskRepository.save(task);
    }
    @PutMapping("/tasks")
    public Task update(@RequestParam Long id, @RequestBody Task task) {
        if(taskRepository.findById(id).orElse(null) != null ) {
            task.setId(id);
            return taskRepository.save(task);
        }
        return new Task();
    }
    @DeleteMapping("/tasks")
    public String delete(@RequestParam Long id) {
        taskRepository.deleteById(id);
        return "OK";
    }
    @PatchMapping("/tasks/{id}")
    public Optional patch(@PathVariable Long id, @RequestBody Task task) {
        if(task.isDone()) {
            taskRepository.markTaskAsDone(id);
        }
        return taskRepository.findById(id);
    }
    @PatchMapping("/tasks/{id}:mark-as-done")
    public Optional patch(@PathVariable Long id){
        taskRepository.markTaskAsDone(id);
        return taskRepository.findById(id);
    }
}
