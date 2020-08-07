This project is modeled after the Web Quiz Engine project from [JetBrains Academy](https://hyperskill.org/).

Each lesson is located on a separate branch.

- [Lesson 1](https://github.com/nantrinh/web_quiz_engine/tree/lesson_1)
- Lesson 2 (this branch)

# Lesson 2

## What this does

This is a service that will accept HTTP requests at http://localhost:8080/api/quiz.
The examples below use [httpie](https://httpie.org/) to demonstrate requests.

### Create a quiz

`http POST http://localhost:8080/api/quizzes title="Food" text="Which food does not start with the letter P?" options:='["Pizza","Pasta","Paneer","Burger"]' answer=3`

returns

```
{
  "id": 1,
  "title": "Food",
  "text": "Which food does not start with the letter P?",
  "options": ["Pizza","Pasta","Paneer","Burger"],
  "answer": 3
}
```

All fields are required.
The `id` field is a generated unique integer identifier for the quiz.

### Get a quiz by id

`http GET http://localhost:8080/api/quizzes/{id}` where `id` is an integer

returns a quiz if it exists, for example:

```
{
  "id": 1,
  "title": "Food",
  "text": "Which food does not start with the letter P?",
  "options": ["Pizza","Pasta","Paneer","Burger"],
}
```

Note that the answer is not included in the response.

If the quiz does not exist, return the 404 status code.

### Get all quizzes

`http GET http://localhost:8080/api/quizzes`

returns a list of the existing quizzes.

For example:

```
[
  {
    "id": 1,
    "title": "Food",
    "text": "Which food does not start with the letter P?",
    "options": ["Pizza","Pasta","Paneer","Burger"],
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

### How to run

`gradle bootRun`

### Solution

See files in [`src/main/java/example/web_quiz_engine`](https://github.com/nantrinh/web_quiz_engine/tree/lesson_2/src/main/java/example/web_quiz_engine).

Many thanks to [Aleksandr](https://hyperskill.org/profile/1948858) and [Arjun](https://hyperskill.org/profile/45563522) for their posted solutions. I could not implement a working solution myself so referred to the solutions for guidance. I felt that the course did not prepare me adequately to do this exercise.

NOTE: ResponseEntity represents an HTTP response, including headers, body, and status. While @ResponseBody puts the return value into the body of the response, ResponseEntity also allows us to add headers and status code.
