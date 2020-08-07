package example.web_quiz_engine;

public class Quiz {
    public static Quiz DEFAULT = new Quiz(
        "The Java Logo",
        "What is depicted on the Java logo?",
        new String[]{"Robot", "Tea leaf", "Cup of coffee", "Bug"},
        2
    );

    private int id;
    private String title;
    private String text;
    private String[] options;
    private int answer;

    public Quiz(String title, String text, String[] options, int answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public Boolean isAnswer(int answer) {
        return this.answer == answer;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public String[] getOptions() {
        return options;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}