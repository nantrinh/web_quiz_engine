package example.web_quiz_engine;

public class Feedback {

    public static String SUCCESS_MESSAGE = "Congratulations, you're right!";

    public static String FAILURE_MESSAGE = "Wrong answer! Please, try again.";

    public Boolean success;
    private String feedback;

    public Feedback(Boolean success) {
        this.success = success;
        this.feedback = success ? SUCCESS_MESSAGE : FAILURE_MESSAGE;
    }

    public String getFeedback() {
        return feedback;
    }

    public boolean isSuccess() {
        return success;
    }
}