package tech.pedroleite.todolistapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.pedroleite.todolistapi.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
