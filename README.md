This project is modeled after the Web Quiz Engine project from [JetBrains Academy](https://hyperskill.org/).

Each lesson is located on a separate branch.

- [Lesson 1](https://github.com/nantrinh/web_quiz_engine/tree/lesson_1)
- Lesson 2 (this branch)

The solution for each lesson mainly uses concepts taught in that lesson.

# Lesson 2 (Work in Progress)

## What this does

This is a service that will accept HTTP requests at http://localhost:8080/api/quiz.
The examples below use [httpie](https://httpie.org/) to demonstrate requests.

### Create a quiz

`http POST http://localhost:8080/api/quizzes title="The Java Logo" text="What is depicted on the Java logo?" options='["Robot","Tea leaf","Cup of coffee","Bug"]' answer=2`

returns

```
{
  "id": 1,
  "title": "The Java Logo",
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"],
  "answer": 2
}
```

All fields are required.
The `id` field is a generated unique integer identifier for the quiz.

### Get a quiz by id

`http GET http://localhost:8080/api/quizzes/{id}` where `id` is an integer

returns

```
{
  "id": 1,
  "title": "The Java Logo",
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"]
}
```

if the quiz exists.

If the quiz does not exist, return the 404 status code.

### Get all quizzes

`http GET http://localhost:8080/api/quizzes`

returns a list of the existing quizzes.

For example:

```
[
  {
    "id": 1,
    "title": "The Java Logo",
    "text": "What is depicted on the Java logo?",
    "options": ["Robot","Tea leaf","Cup of coffee","Bug"]
  },
  {
    "id": 2,
    "title": "The Ultimate Question",
    "text": "What is the answer to the Ultimate Question of Life, the Universe and Everything?",
    "options": ["Everything goes right","42","2+2=4","11011100"]
  }
]
```

If no quizzes exist, return an empty array `[]`.

### Solve a quiz

`http POST /api/quizzes/{id}/solve?answer={answer}`, where answer refers to an index of an option from the options array.

returns

```
{
  "success": true,
  "feedback": "Congratulations, you're right!"
}
```

if correct

or

```
{
  "success": false,
  "feedback": "Wrong answer! Please, try again."
}
```

if incorrect.

If the quiz does not exist, return the `404` status code.

## How to implement

[TODO]

### How to run

`gradle bootRun`

### Solution

See files in [`src/main/java/example/web_quiz_engine`](https://github.com/nantrinh/web_quiz_engine/tree/lesson_2/src/main/java/example/web_quiz_engine).
