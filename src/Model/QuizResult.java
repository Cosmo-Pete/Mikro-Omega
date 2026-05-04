package Model;

import java.time.LocalDateTime;

public class QuizResult {

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

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public LocalDateTime getDate() {
        return date;
    }

    // Výpočty
    public double getAccuracyPercentage() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "";
    }
}