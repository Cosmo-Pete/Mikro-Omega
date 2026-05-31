package Model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class QuizResult implements Serializable {

    private Player player;
    private Category category;
    private String difficulty;
    private int score;
    private int totalQuestions;
    private int correctAnswers;
    private long timeTaken;             // sekundy
    private LocalDateTime date;

    public QuizResult(Player player, Category category, String difficulty,
                      int score, int totalQuestions, int correctAnswers, long timeTaken) {
        this.player = player;
        this.category = category;
        this.difficulty = difficulty;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.timeTaken = timeTaken;
        this.date = LocalDateTime.now();
    }

    // Getters
    public Player getPlayer() {
        return player;
    }

    public Category getCategory() {
        return category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getScore() {
        return score;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public LocalDateTime getDate() {
        return date;
    }

    // calculations
    public double getAccuracyPercentage() {
        if (totalQuestions == 0) return 0;
        return ((double) correctAnswers / totalQuestions) * 100;
    }

    @Override
    public String toString() {
        return "";
    }
}