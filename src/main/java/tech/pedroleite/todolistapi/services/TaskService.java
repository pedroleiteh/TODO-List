package tech.pedroleite.todolistapi.services;

import org.springframework.stereotype.Service;
import tech.pedroleite.todolistapi.entities.Task;
import tech.pedroleite.todolistapi.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> findAll() {

        return taskRepository.findAll();
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
