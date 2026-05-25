package Windows;

import Logic.ScoreBoard;
import Model.QuizResult;
import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {

    private QuizResult result;

    // Labels for displaying results
    private JLabel titleLabel;
    private JLabel scoreLabel;
    private JLabel accuracyLabel;
    private JLabel timeLabel;
    private JLabel messageLabel;

    // Navigation buttons
    private JButton playAgainButton;
    private JButton mainMenuButton;
    private JButton scoreBoardButton;

    /**
     * Creates the result panel displaying the quiz outcome.
     * @param result the result of the finished quiz
     */
    public ResultPanel(QuizResult result) {
        this.result = result;
        initComponents();
        setupLayout();
        setupListeners();
        displayResult(result);
    }

    /**
     * Initializes all UI components.
     */
    private void initComponents() {
        titleLabel = new JLabel("Quiz Finished!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));

        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 20));

        scoreLabel = new JLabel("", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        accuracyLabel = new JLabel("", SwingConstants.CENTER);
        accuracyLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        playAgainButton = new JButton("Play Again");
        mainMenuButton = new JButton("Main Menu");
        scoreBoardButton = new JButton("Scoreboard");
    }

    /**
     * Sets up the layout of all components.
     * Title and message at top, stats in center, buttons at bottom.
     */
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        // --- TOP: title and message ---
        JPanel topPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        topPanel.add(titleLabel);
        topPanel.add(messageLabel);

        // --- CENTER: statistics ---
        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 5, 10));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 200, 20, 200));
        centerPanel.add(scoreLabel);
        centerPanel.add(accuracyLabel);
        centerPanel.add(timeLabel);

        // --- BOTTOM: buttons ---
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.add(playAgainButton);
        bottomPanel.add(mainMenuButton);
        bottomPanel.add(scoreBoardButton);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Sets up action listeners for navigation buttons.
     */
    private void setupListeners() {
        // Switch back to main menu
        mainMenuButton.addActionListener(e -> {
            MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(this);
            frame.switchPanel(frame.getMainPanel());
        });

        // Open scoreboard window using Singleton
        scoreBoardButton.addActionListener(e -> {
            new ScoreBoardWindow(ScoreBoard.getInstance()).setVisible(true);
        });

        // Play again – switch back to main menu to reselect options
        playAgainButton.addActionListener(e -> {
            MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(this);
            frame.switchPanel(frame.getMainPanel());
        });
    }

    /**
     * Fills in all result labels with data from the QuizResult.
     * @param result the quiz result to display
     */
    public void displayResult(QuizResult result) {
        scoreLabel.setText("Score: " + result.getScore());
        accuracyLabel.setText("Accuracy: " + String.format("%.1f", result.getAccuracyPercentage()) + "%");
        timeLabel.setText("Time: " + result.getTimeTaken() + "s");
        messageLabel.setText(getResultMessage(result.getAccuracyPercentage()));
    }

    /**
     * Returns a message based on accuracy percentage.
     * @param accuracy percentage of correct answers
     * @return message string
     */
    private String getResultMessage(double accuracy) {
        if (accuracy >= 90) return "Outstanding! 🏆";
        if (accuracy >= 75) return "Great job! 🎉";
        if (accuracy >= 50) return "Not bad, keep practicing!";
        return "Better luck next time!";
    }
}