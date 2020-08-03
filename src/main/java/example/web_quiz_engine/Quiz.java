package example.web_quiz_engine;

public class Quiz {
    public static final Quiz DEFAULT = new Quiz(
        "The Java Logo",
        "What is depicted on the Java logo?",
        new String[]{"Robot", "Tea leaf", "Cup of coffee", "Bug"},
        2
    );

    public String title;
    public String text;
    public String[] options;
    private int answer;

    public Quiz(String title, String text, String[] options, int answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }
}