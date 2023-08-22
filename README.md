# TODO List API
[![Generic badge](https://img.shields.io/badge/Tipo-Desafio-green.svg)](https://shields.io/)

API feita usando a stack: Java, Spring, Mysql, feita para gerenciar tarefas(tasks).  
[Desafio Proposto](https://github.com/simplify-liferay/desafio-junior-backend-simplify)

## Tecnologias Utilizadas
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Web MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/)

## Boas Práticas Utilizadas
- SOLID, DRY
- API Rest
- Injeção de Depêndencias
- Geração automática do Swagger com OpenAPI 3
- Testes automátizados

## Como Executar
- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
```
java -jar target/todolistapi-0.0.1-SNAPSHOT.jar
```
A API poderá ser acessada em localhost:8080. O Swagger poderá ser visualizado em localhost:8080/swagger-ui.html
# API Endpoints
- Criar Tarefa
```
http POST :8080/tasks name="Task 1" description="Desc Task 1" priority=MEDIUM

[
  {
    "descricao": "Desc Task 1",
    "id": 1,
    "nome": "Task 1",
    "prioridade": MEDIUM,
    "realizado": false
  }
]
```

