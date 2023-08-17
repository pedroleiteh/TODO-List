package tech.pedroleite.todolistapi.controllers;

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

        return ResponseEntity.ok().body(taskService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> saveTask(@RequestBody Task task) {
        taskService.save(task);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(uri).body("Task salva com sucesso.");
    }

    @PutMapping
    public ResponseEntity<String> updateTask(@RequestBody Task task) {
        taskService.save(task);
        return ResponseEntity.ok("Task atualizada com sucesso.");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.delete(id);

        return new ResponseEntity<>("Task deletada com sucesso.", HttpStatus.OK);
    }

}
