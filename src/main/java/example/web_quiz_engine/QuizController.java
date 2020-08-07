package example.web_quiz_engine;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class QuizController{

    private final QuizService quizService = new QuizService();

    @PostMapping(value = "api/quizzes", consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody Quiz quiz) {
        quizService.create(quiz);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @GetMapping("/api/quizzes")
    public ResponseEntity<List<Quiz>> readAll() {
        final List<Quiz> allQuizzes = quizService.readAll();
        return new ResponseEntity<>(allQuizzes, HttpStatus.OK);
    }

}