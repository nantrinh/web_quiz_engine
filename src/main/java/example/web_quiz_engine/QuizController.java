package example.web_quiz_engine;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class QuizController{

    private final QuizService quizService = new QuizService();

    @GetMapping("/api/quizzes")
    public ResponseEntity<List<Quiz>> getAll() {

        quizService.addNextDummyQuiz();

        final List<Quiz> allQuizzes = quizService.getAll();
        return new ResponseEntity<>(allQuizzes, HttpStatus.OK);
    }

    /* lesson 1 */

    @GetMapping("/api/quiz")
    public Quiz getQuiz() {
        return Quiz.DEFAULT;
    }

    @PostMapping("/api/quiz")
    public Answer checkAnswer(@RequestParam(value="answer") int answer) {
        if (Quiz.DEFAULT.isAnswer(answer)) {
            return Answer.CORRECT;
        } else {
            return Answer.WRONG;
        }
    }
}