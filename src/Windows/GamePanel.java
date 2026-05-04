package Windows;

import Logic.QuizManager;
import Model.Question;
import javax.swing.*;

public class GamePanel extends JPanel {

    private QuizManager quizManager;
    private JLabel questionLabel;
    private JLabel timerLabel;
    private JLabel scoreLabel;
    private JLabel progressLabel;        // "Otázka 3/10"
    private JButton[] answerButtons;     // pro multiple choice
    private JButton trueButton;
    private JButton falseButton;
    private JButton skipButton;

    public GamePanel(QuizManager quizManager) {
        this.quizManager = quizManager;
        initComponents();
        setupLayout();
        setupListeners();
    }

    private void initComponents() {
        // TODO: Implementace
    }

    private void setupLayout() {
        // TODO: Implementace
    }

    private void setupListeners() {
        // TODO: Implementace
    }

    // Aktualizace UI
    public void displayQuestion(Question question) {
        // TODO: Implementace
    }

    public void updateTimer(int seconds) {
        // TODO: Implementace
    }

    public void updateScore(int score) {
        // TODO: Implementace
    }

    public void showCorrectAnswer() {
        // TODO: Implementace
    }

    public void lockAnswers() {
        // TODO: Implementace
    }
}