package tech.pedroleite.todolistapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import tech.pedroleite.todolistapi.entities.enums.PriorityEnum;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private boolean done;
    private PriorityEnum priority;

    public Task() {
    }

    public Task(Long id, String name, String desc, boolean done, PriorityEnum priority) {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.done = done;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(getId(), task.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
