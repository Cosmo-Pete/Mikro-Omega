package Model;

public class TrueFalseQuestion extends Question {

    private boolean correctAnswer;

    public TrueFalseQuestion(String questionText, String difficulty,
                              Category category, int timeLimit,
                              boolean correctAnswer) {
        super(questionText, difficulty, category, timeLimit);
        this.correctAnswer = correctAnswer;
    }

    // Getters
    public Boolean getCorrectAnswer() {
        return correctAnswer;
    }

    // Implementace z Answerable
    @Override
    public boolean checkAnswer(Object answer) {
        return false;
    }

    @Override
    public String getFormattedQuestion() {
        return "";
    }
}
