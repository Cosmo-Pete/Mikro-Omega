package Windows;

import Model.QuizResult;
import javax.swing.*;

public class ResultPanel extends JPanel {

    private QuizResult result;
    private JLabel scoreLabel;
    private JLabel accuracyLabel;
    private JLabel timeLabel;
    private JLabel messageLabel;        // "Skvělá práce!" apod.
    private JButton playAgainButton;
    private JButton mainMenuButton;
    private JButton scoreBoardButton;

    public ResultPanel(QuizResult result) {
        this.result = result;
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

    // Zobrazení výsledků
    public void displayResult(QuizResult result) {
        // TODO: Implementace
    }

    private String getResultMessage(double accuracy) {
        return "";
    }
}