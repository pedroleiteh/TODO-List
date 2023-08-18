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


    public List<Task> listTasks() {
        Sort sort = Sort.by("priority").ascending().and(
                Sort.by("name").ascending()
        );
        return taskRepository.findAll(sort);
    }

    public List<Task> save(Task task) {

        taskRepository.save(task);
        return listTasks();
    }

    public List<Task> delete(Long id) {

        taskRepository.deleteById(id);
        return listTasks();
    }
}
