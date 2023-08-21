package tech.pedroleite.todolistapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import tech.pedroleite.todolistapi.entities.Task;
import tech.pedroleite.todolistapi.entities.enums.PriorityEnum;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodolistapiApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateTaskSuccess () {
        var task = new Task(null, "Task test", "Testing create task.", false, PriorityEnum.LOW);

        webTestClient
                .post()
                .uri("/tasks")
                .bodyValue(task)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo(task.getName())
                .jsonPath("$[0].description").isEqualTo(task.getDescription())
                .jsonPath("$[0].done").isEqualTo(task.isDone());


    }
    @Test
    void testCreateTaskFailure () {
        webTestClient
                .post()
                .uri("/tasks")
                .bodyValue( new Task(null, "", "", false, PriorityEnum.MEDIUM))
                .exchange()
                .expectStatus().isBadRequest();

    }
}
