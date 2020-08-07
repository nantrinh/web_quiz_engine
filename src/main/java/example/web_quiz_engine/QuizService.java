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

    public List<Quiz> getAll() {
        return new ArrayList<>(QUIZ_REPO_MAP.values());
    }

    public void addNextDummyQuiz() {
        int nextId = QUIZ_ID.incrementAndGet();
        Quiz newQuiz = new Quiz("Quiz " + nextId, "Q" + nextId, new String[]{"1", "2", "3", "4"}, 1);
        QUIZ_REPO_MAP.put(nextId, newQuiz);
    }
}

