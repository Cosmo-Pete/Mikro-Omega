package Model;

import java.util.List;

public class MultipleChoiceQuestion extends Question {

    private List<String> options;       // seznam možností A, B, C, D
    private int correctIndex;           // index správné odpovědi

    public MultipleChoiceQuestion(String questionText, String difficulty,
                                   Category category, int timeLimit,
                                   List<String> options, int correctIndex) {
        super(questionText, difficulty, category, timeLimit);
        this.options = options;
        this.correctIndex = correctIndex;
    }

    // Getters
    public List<String> getOptions() {
        return options;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }

    // Implementace z Answerable
    @Override
    public boolean checkAnswer(Object answer) {
        return false;
    }

    @Override
    public Object getCorrectAnswer() {
        return null;
    }

    @Override
    public String getFormattedQuestion() {
        return "";
    }
}
