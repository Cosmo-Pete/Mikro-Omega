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
    private long startTime;
    private ScoreBoard scoreBoard;

    public QuizManager(Player player, List<Question> questions, ScoreBoard scoreBoard) {
        this.currentPlayer = player;
        this.questions = questions;
        this.scoreBoard = scoreBoard;
        this.currentIndex = 0;
        this.score = 0;
        this.correctAnswers = 0;
        this.timer = new Timer(30);
    }


    public void startQuiz() {
        currentIndex = 0;
        score = 0;
        correctAnswers = 0;
        timer.resetTODefault(questions.get(0).getTimeLimit());
        timer.start();
        startTime = System.currentTimeMillis();
    }

    public void nextQuestion() {
        currentIndex++;
        if (!isQuizFinished()) {
            timer.resetTODefault(questions.get(currentIndex).getTimeLimit());
            timer.start();
        }
    }

    public void skipQuestion() {
        currentIndex++;
        timer.resetTODefault();
        if (!isQuizFinished()){
            timer.start();
        }
    }

    public boolean submitAnswer(Object answer) {
        boolean correct = questions.get(currentIndex).checkAnswer(answer);
        if (correct) {
            score += calculatePoints(true, timer.getRemainingSeconds());
            correctAnswers++;
        }
        return correct;
    }

    public boolean isQuizFinished() {
        return currentIndex >= questions.size();
    }


    public int calculatePoints(boolean correct, long timeRemaining) {
        if (!correct) return 0;
        return 100 + (int)(timeRemaining * 5);
    }

    public int getCurrentScore() {
        return score;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    // Gettery
    public Question getCurrentQuestion() {
        return questions.get(currentIndex);
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

    public Timer getTimer() {
        return timer;
    }

    /**
     * Finishes the quiz and returns the result.
     * @return QuizResult with all quiz data
     */
    public QuizResult finishQuiz() {
        timer.stop();
        long timeTaken = (System.currentTimeMillis() - startTime) / 1000;
        QuizResult result = new QuizResult(
                currentPlayer,
                questions.get(0).getCategory(),
                questions.get(0).getDifficulty(),
                score,
                questions.size(),
                correctAnswers,
                timeTaken
        );
        scoreBoard.addResult(result);
        return result;
    }




}