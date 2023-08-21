package tech.pedroleite.todolistapi.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.pedroleite.todolistapi.entities.Task;
import tech.pedroleite.todolistapi.services.TaskService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> listAllTasks() {

        return ResponseEntity.ok().body(taskService.listTasks());
    }

    @PostMapping
    public ResponseEntity<List<Task>> saveTask(@RequestBody @Valid Task task) {
        taskService.save(task);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(uri).body(taskService.listTasks());
    }

    @PutMapping
    public ResponseEntity<List<Task>> updateTask(@RequestBody Task task) {
        taskService.save(task);
        return ResponseEntity.ok(taskService.listTasks());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Task>> deleteTask(@PathVariable Long id) {
        taskService.delete(id);

        return ResponseEntity.ok(taskService.listTasks());
    }

}
