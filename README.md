# JUnit Testing – Spring Boot

A beginner-friendly demo project showing how to **test Spring Boot applications** using **JUnit 5**, **Mockito** and **MockMvc**.

The goal of this repository is to learn and practice the main types of tests you write in a typical Spring Boot project, with simple code that is easy to read and run.

---

## Tech Stack

| Tool | Purpose |
|------|---------|
| Java 17 | Programming language |
| Spring Boot | Application framework |
| JUnit 5 | Writing and running tests |
| Mockito | Mocking dependencies in unit tests |
| MockMvc | Testing REST controllers without starting a server |
| Maven | Build and dependency management |

---

## What You Will Learn

- Writing **unit tests** with JUnit 5 (`@Test`, `@BeforeEach`, assertions)
- Mocking dependencies with **Mockito** (`@Mock`, `@InjectMocks`, `when(...).thenReturn(...)`, `verify(...)`)
- Testing the **service layer** in isolation
- Testing **REST controllers** with **MockMvc** (`@WebMvcTest`, `perform(...)`, `andExpect(...)`)
- Checking HTTP status codes and JSON responses
- Running all tests with a single Maven command

---

## Project Structure

```
JUnit-Testing-Spring-Boot
└── spring-testing-demo
    ├── src
    │   ├── main/java        # Application code (controller, service, model, ...)
    │   └── test/java        # Test classes (JUnit 5, Mockito, MockMvc)
    └── pom.xml              # Maven configuration and dependencies
```

---

## Getting Started

### Prerequisites

- JDK 17 or later
- Maven 3.8+ (or use the Maven wrapper if included)
- Any IDE (IntelliJ IDEA, Eclipse, VS Code)

### Clone the Repository

```bash
git clone https://github.com/prasadk30/JUnit-Testing-Spring-Boot.git
cd JUnit-Testing-Spring-Boot/spring-testing-demo
```

### Run the Application

```bash
mvn spring-boot:run
```

### Run All Tests

```bash
mvn test
```

### Run a Single Test Class

```bash
mvn -Dtest=YourTestClassName test
```

Test reports are generated in `target/surefire-reports/`.

---

## Testing Approach

### 1. Unit Tests with Mockito
The service layer is tested on its own. Dependencies such as repositories are replaced with Mockito mocks, so the tests are fast and do not need a database.

### 2. Controller Tests with MockMvc
REST endpoints are tested using `MockMvc`. This lets you send fake HTTP requests and check the status code and response body without starting the full server.

---

## Example Test

```java
@Test
void shouldReturnExpectedResult() {
    // Arrange
    when(repository.findById(1L)).thenReturn(Optional.of(item));

    // Act
    Item result = service.getById(1L);

    // Assert
    assertEquals("Sample", result.getName());
    verify(repository).findById(1L);
}
```

---

## Contributing

This is a learning project, but suggestions are welcome. Feel free to open an issue or submit a pull request.

---

## Author

**Prasad**
GitHub: [@prasadk30](https://github.com/prasadk30)
