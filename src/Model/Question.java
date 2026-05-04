package Model;

import Interface.Answerable;

public abstract class Question implements Answerable {

    protected String questionText;
    protected String difficulty;   // "easy", "medium", "hard"
    protected Category category;
    protected int timeLimit;       // seconds

    public Question(String questionText, String difficulty, Category category, int timeLimit) {
        this.questionText = questionText;
        this.difficulty = difficulty;
        this.category = category;
        this.timeLimit = timeLimit;
    }

    // Getters
    public String getQuestionText() {
        return questionText;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public Category getCategory() {
        return category;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    // Abstract – každá podtřída implementuje po svém
    public abstract boolean checkAnswer(Object answer);
    public abstract Object getCorrectAnswer();
    public abstract String getFormattedQuestion();
}
