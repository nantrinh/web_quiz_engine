package example.web_quiz_engine;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class QuizService {
    // local data store 
    private static final Map<Integer, Quiz> QUIZ_REPO_MAP = new HashMap<>();
    // to increment the id 
    private static final AtomicInteger QUIZ_ID = new AtomicInteger();

    public Quiz create(Quiz quiz) {
        int id = QUIZ_ID.incrementAndGet();
        quiz.setId(id);
        QUIZ_REPO_MAP.put(id, quiz);
        return quiz;
    }

    public List<Quiz> readAll() {
        return new ArrayList<>(QUIZ_REPO_MAP.values());
    }

}

