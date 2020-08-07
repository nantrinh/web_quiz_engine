package example.web_quiz_engine;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequestMapping("/api/quizzes")
@RestController
public class QuizController{

    private final QuizService quizService = new QuizService();

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Quiz quiz) {
        quizService.create(quiz);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable int id) {
        Quiz quiz = quizService.read(id);
        if (quiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(quiz, HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> readAll() {
        final List<Quiz> allQuizzes = quizService.readAll();
        return new ResponseEntity<>(allQuizzes, HttpStatus.OK);
    }

    @PostMapping("{id}/solve")
    public ResponseEntity<Feedback> solve(@PathVariable int id, @RequestParam int answer) {
        Quiz quiz = quizService.read(id);
        if (quiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new Feedback(quizService.solve(quiz, answer)), HttpStatus.OK);
        }
    }
}