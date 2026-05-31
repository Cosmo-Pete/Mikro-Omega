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

    /**
     * Checks if the given answer matches the correct answer.
     *
     * @param answer the boolean answer (true or false)
     * @return true if correct, false otherwise
     */
    @Override
    public boolean checkAnswer(Object answer) {
        if (answer instanceof Boolean) {
            return (Boolean) answer == correctAnswer;
        }
        return false;
    }
}