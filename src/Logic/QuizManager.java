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
        currentIndex = 0;
        score = 0;
        timer.start();
        timer.reset();
    }

    public void nextQuestion() {
        currentIndex++;
        timer.reset();
        if (!isQuizFinished()) {
            timer.start();

        }
    }

    public void skipQuestion() {
        currentIndex++;
        timer.reset();
        if (!isQuizFinished()){
            timer.start();
        }
    }

    public boolean submitAnswer(Object answer) {
        boolean correct = questions.get(currentIndex).checkAnswer(answer);
        if (correct){
            score += calculatePoints(true, timer.getRemainingSeconds());
        }
        correctAnswers++;
        return correct;
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