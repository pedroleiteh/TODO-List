package tech.pedroleite.todolistapi.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tech.pedroleite.todolistapi.entities.Task;
import tech.pedroleite.todolistapi.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> findAll() {
        Sort sort = Sort.by("priority").ascending().and(
                Sort.by("name").ascending()
        );
        return taskRepository.findAll(sort);
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
