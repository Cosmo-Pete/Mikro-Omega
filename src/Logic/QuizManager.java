package Logic;

import Model.*;
import java.util.List;

/**
 * Manages the quiz flow, scoring, and question navigation.
 * Handles answer submission, timer control, and result generation.
 */
public class QuizManager {

    private List<Question> questions;   // list of questions for current quiz
    private int currentIndex;           // index of current question
    private int score;                  // current score
    private int correctAnswers;         // number of correct answers
    private Player currentPlayer;       // player playing the quiz
    private Timer timer;                // timer for each question
    private long startTime;             // time when quiz started
    private ScoreBoard scoreBoard;      // reference to scoreboard for saving results

    /**
     * Creates a new QuizManager with the given player, questions and scoreboard.
     * @param player the player playing the quiz
     * @param questions list of questions to ask
     * @param scoreBoard reference to the scoreboard
     */
    public QuizManager(Player player, List<Question> questions, ScoreBoard scoreBoard) {
        this.currentPlayer = player;
        this.questions = questions;
        this.scoreBoard = scoreBoard;
        this.currentIndex = 0;
        this.score = 0;
        this.correctAnswers = 0;
        this.timer = new Timer(30);
    }

    /**
     * Starts the quiz by resetting all values and starting the timer.
     */
    public void startQuiz() {
        currentIndex = 0;
        score = 0;
        correctAnswers = 0;
        timer.resetTODefault(questions.get(0).getTimeLimit());
        timer.start();
        startTime = System.currentTimeMillis();
    }


    /**
     * Moves to the next question and resets the timer.
     * Does nothing if quiz is finished.
     */
    public void nextQuestion() {
        currentIndex++;
        if (!isQuizFinished()) {
            timer.resetTODefault(questions.get(currentIndex).getTimeLimit());
            timer.start();
        }
    }

    /**
     * Skips the current question and moves to the next one.
     */
    public void skipQuestion() {
        currentIndex++;
        timer.resetTODefault();
        if (!isQuizFinished()) {
            timer.start();
        }
    }

    /**
     * Submits an answer for the current question.
     * Awards points if the answer is correct.
     * @param answer the submitted answer
     * @return true if the answer is correct, false otherwise
     */
    public boolean submitAnswer(Object answer) {
        boolean correct = questions.get(currentIndex).checkAnswer(answer);
        if (correct) {
            score += calculatePoints(true, timer.getRemainingSeconds());
            correctAnswers++;
        }
        return correct;
    }

    /**
     * Returns true if all questions have been answered.
     * @return true if quiz is finished
     */
    public boolean isQuizFinished() {
        return currentIndex >= questions.size();
    }

    /**
     * Calculates points for an answer based on correctness and remaining time.
     * @param correct whether the answer was correct
     * @param timeRemaining remaining seconds on the timer
     * @return points awarded
     */
    public int calculatePoints(boolean correct, long timeRemaining) {
        if (!correct) return 0;
        return 100 + (int)(timeRemaining * 5);
    }

    /**
     * Returns the current score.
     * @return current score
     */
    public int getCurrentScore() {
        return score;
    }



    /**
     * Returns the current question.
     * @return current question
     */
    public Question getCurrentQuestion() {
        return questions.get(currentIndex);
    }

    /**
     * Returns the index of the current question.
     * @return current question index
     */
    public int getCurrentIndex() {
        return currentIndex;
    }

    /**
     * Returns the total number of questions.
     * @return total question count
     */
    public int getTotalQuestions() {
        return questions.size();
    }


    /**
     * Returns the timer.
     * @return timer
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     * Finishes the quiz, saves the result to scoreboard and returns it.
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