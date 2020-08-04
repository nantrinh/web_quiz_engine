package example.web_quiz_engine;

public class Answer {
    public static Answer CORRECT = new Answer(
        true,
        "Congratulations, you're right!"
    );

    public static Answer WRONG = new Answer(
        false,
        "Wrong answer! Please, try again."
    );

    public Boolean success;
    public String feedback;

    public Answer(Boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }
}