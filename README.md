This project is modeled after the Web Quiz Engine project from [JetBrains Academy](https://hyperskill.org/).

Each lesson is located on a separate branch.

- Lesson 1 (this branch)
- [Lesson 2](https://github.com/nantrinh/web_quiz_engine/tree/lesson_2)

The solution for each lesson mainly uses concepts taught in that lesson.

# Lesson 1

## What this does

This is a service that will accept HTTP requests at http://localhost:8080/api/quiz.
The examples below use [httpie](https://httpie.org/) to demonstrate requests.

### GET

`http GET http://localhost:8080/api/quiz`

returns

```
{
  "title": "The Java Logo",
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"]
}
```

### POST

`http POST http://localhost:8080/api/quiz?answer={answer}` where `answer` is an integer

returns

```
{
  "success": true,
  "feedback": "Congratulations, you're right!"
}
```

if the value passed in for `answer` is `2`

and

```
{
  "success": false,
  "feedback": "Wrong answer! Please, try again."
}
```

otherwise.

## How to implement

### Spring Initialzr

Use [Spring Initialzr](https://start.spring.io/) to generate a starter project.

![spring_initialzr_settings](README_assets/images/spring_initialzr.png)

Settings:

- Gradle Project
- Java
- Spring Boot 2.3.2
- Metadata
  - Group: example
  - Artifact: web_quiz_engine
  - Name: web_quiz_engine
  - Description: Web Quiz Engine API
  - Package name: example.web_quiz_engine
  - Packaging: Jar
  - Java: 14
- Dependencies
  - Spring Web

### How to run

`gradle bootRun`

### Solution

See files in [`src/main/java/example/web_quiz_engine`](https://github.com/nantrinh/web_quiz_engine/tree/lesson_1/src/main/java/example/web_quiz_engine).

Note: The `static` keyword is not covered until lesson 2. The `static` keyword makes `DEFAULT`, `CORRECT`, and `WRONG` class variables, so you can access them directly from their respective classes, instead of creating an instance first.
