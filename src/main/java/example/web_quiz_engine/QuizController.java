package example.web_quiz_engine;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class QuizController{

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

}