package Model;

public class Player {

    private String name;
    private int totalScore;
    private int gamesPlayed;
    private int correctAnswers;
    private int totalAnswers;

    public Player(String name) {
        this.name = name;
        this.totalScore = 0;
        this.gamesPlayed = 0;
        this.correctAnswers = 0;
        this.totalAnswers = 0;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getTotalAnswers() {
        return totalAnswers;
    }

    // Setters / updaters
    public void addScore(int points) {
        // TODO: Implementace
    }

    public void incrementGamesPlayed() {
        // TODO: Implementace
    }

    public void recordAnswer(boolean wasCorrect) {
        // TODO: Implementace
    }

    // Výpočty
    public double getAccuracy() {
        return 0.0;
    }

    public double getAverageScore() {
        return 0.0;
    }

    @Override
    public String toString() {
        return name;
    }
}