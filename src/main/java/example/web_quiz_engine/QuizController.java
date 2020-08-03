package example.web_quiz_engine;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class QuizController{

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

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