package example.web_quiz_engine;

import com.fasterxml.jackson.annotation.*;

public class Quiz {

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

    @JsonIgnore
    @JsonProperty
    public int getAnswer() {
        return answer;
    }

    public int getId() {
        return id;
    }

    public String[] getOptions() {
        return options;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }


}