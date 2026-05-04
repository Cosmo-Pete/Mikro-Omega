package Logic;

import Model.*;
import java.util.List;

public class QuizManager {

    private List<Question> questions;
    private int currentIndex;
    private int score;
    private int correctAnswers;
    private Player currentPlayer;
    private Timer timer;

    public QuizManager(Player player, List<Question> questions) {
        this.currentPlayer = player;
        this.questions = questions;
        this.currentIndex = 0;
        this.score = 0;
        this.correctAnswers = 0;
    }

    // Průběh kvízu
    public void startQuiz() {
        // TODO: Implementace
    }

    public void nextQuestion() {
        // TODO: Implementace
    }

    public void skipQuestion() {
        // TODO: Implementace
    }

    public boolean submitAnswer(Object answer) {
        return false;
    }

    public boolean isQuizFinished() {
        return false;
    }

    // Skóre
    public int calculatePoints(boolean correct, long timeRemaining) {
        return 0;
    }

    public int getCurrentScore() {
        return score;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    // Gettery
    public Question getCurrentQuestion() {
        return null;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    // Výsledek
    public QuizResult finishQuiz() {
        return null;
    }
}