package Model;

import java.util.List;

public class MultipleChoiceQuestion extends Question {

    private List<String> options;       // list of answer options
    private int correctIndex;           // index of the correct answer

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

    /**
     * Checks if the given answer index matches the correct answer index.
     * @param answer the index of the selected option
     * @return true if correct, false otherwise
     */
    @Override
    public boolean checkAnswer(Object answer) {
        if (answer instanceof Integer) {
            return (Integer) answer == correctIndex;
        }
        return false;
    }

    /**
     * Returns the correct answer index.
     * @return correct index
     */
    @Override
    public Object getCorrectAnswer() {
        return correctIndex;
    }

    /**
     * Returns the formatted question with all options.
     * @return formatted question string
     */
    @Override
    public String getFormattedQuestion() {
        String result = getQuestionText() + "\n";
        for (int i = 0; i < options.size(); i++) {
            result += (char) ('A' + i) + ") " + options.get(i) + "\n";
        }
        return result;
    }
}