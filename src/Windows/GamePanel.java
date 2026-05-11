package Windows;

import Logic.QuizManager;
import Model.MultipleChoiceQuestion;
import Model.Question;
import Model.TrueFalseQuestion;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private QuizManager quizManager;

    // Labels for displaying game info
    private JLabel questionLabel;
    private JLabel timerLabel;
    private JLabel scoreLabel;
    private JLabel progressLabel;   // "Question 3/10"

    // Answer buttons
    private JButton[] answerButtons;    // 4 buttons for multiple choice
    private JButton trueButton;
    private JButton falseButton;
    private JButton skipButton;

    // Panels for layout organization
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;

    /**
     * Creates the game panel with the given quiz manager.
     * @param quizManager handles quiz logic and state
     */
    public GamePanel(QuizManager quizManager) {
        this.quizManager = quizManager;
        initComponents();
        setupLayout();
        setupListeners();
    }

    private void showResults() {
        MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(this);
        frame.switchPanel(new ResultPanel(quizManager.finishQuiz(), scoreBoard));
    }

    /**
     * Initializes all UI components with default values.
     */
    private void initComponents() {
        // Initialize labels
        questionLabel = new JLabel("Question", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 22));

        timerLabel = new JLabel("Time: 30", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        progressLabel = new JLabel("Question 1/10", SwingConstants.CENTER);
        progressLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // Initialize 4 answer buttons for multiple choice
        answerButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new JButton("Option " + (i + 1));
            answerButtons[i].setFont(new Font("Arial", Font.PLAIN, 14));
        }

        // Initialize true/false buttons
        trueButton = new JButton("True");
        falseButton = new JButton("False");
        trueButton.setFont(new Font("Arial", Font.PLAIN, 14));
        falseButton.setFont(new Font("Arial", Font.PLAIN, 14));

        // True/false buttons hidden by default
        trueButton.setVisible(false);
        falseButton.setVisible(false);

        // Skip button
        skipButton = new JButton("Skip");
        skipButton.setFont(new Font("Arial", Font.PLAIN, 12));
    }

    /**
     * Sets up the layout of all components.
     * Top: timer, score, progress
     * Center: question text
     * Bottom: answer buttons and skip
     */
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        // --- TOP PANEL: timer, score, progress ---
        topPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.add(timerLabel);
        topPanel.add(progressLabel);
        topPanel.add(scoreLabel);

        // --- CENTER PANEL: question ---
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        centerPanel.add(questionLabel, BorderLayout.CENTER);

        // --- BOTTOM PANEL: answer buttons ---
        bottomPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));

        // Add all answer buttons
        for (JButton btn : answerButtons) {
            bottomPanel.add(btn);
        }

        // True/false buttons
        bottomPanel.add(trueButton);
        bottomPanel.add(falseButton);

        // Skip button spans full width
        JPanel skipPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        skipPanel.setBackground(Color.WHITE);
        skipPanel.add(skipButton);
        bottomPanel.add(skipPanel);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Sets up action listeners for all buttons.
     */
    private void setupListeners() {
        // Multiple choice buttons – pass index as answer
        for (int i = 0; i < answerButtons.length; i++) {
            final int index = i;
            answerButtons[i].addActionListener(e -> {
                quizManager.submitAnswer(index);
                showCorrectAnswer();
                lockAnswers();
            });
        }

        // True/false buttons
        trueButton.addActionListener(e -> {
            quizManager.submitAnswer(true);
            showCorrectAnswer();
            lockAnswers();
        });

        falseButton.addActionListener(e -> {
            quizManager.submitAnswer(false);
            showCorrectAnswer();
            lockAnswers();
        });

        // Skip button
        skipButton.addActionListener(e -> {
            quizManager.skipQuestion();
            if (quizManager.isQuizFinished()) {
                showResults();
            } else {
                displayQuestion(quizManager.getCurrentQuestion());
            }
        });
    }

    /**
     * Displays the given question and updates all relevant UI elements.
     * Shows appropriate buttons based on question type.
     * @param question the question to display
     */
    public void displayQuestion(Question question) {
        // Update question text and progress
        questionLabel.setText("<html><center>" + question.getQuestionText() + "</center></html>");
        progressLabel.setText("Question " + (quizManager.getCurrentIndex() + 1)
                + "/" + quizManager.getTotalQuestions());

        // Reset button colors
        for (JButton btn : answerButtons) {
            btn.setBackground(null);
        }
        trueButton.setBackground(null);
        falseButton.setBackground(null);

        // Show correct button type based on question type
        if (question instanceof MultipleChoiceQuestion multipleChoice) {
            // Show multiple choice buttons, hide true/false
            for (int i = 0; i < answerButtons.length; i++) {
                answerButtons[i].setVisible(true);
                answerButtons[i].setEnabled(true);
                answerButtons[i].setText(multipleChoice.getOptions().get(i));
            }
            trueButton.setVisible(false);
            falseButton.setVisible(false);

        } else if (question instanceof TrueFalseQuestion) {
            // Hide multiple choice, show true/false
            for (JButton btn : answerButtons) {
                btn.setVisible(false);
            }
            trueButton.setVisible(true);
            falseButton.setVisible(true);
            trueButton.setEnabled(true);
            falseButton.setEnabled(true);
        }

        revalidate();
        repaint();
    }

    /**
     * Updates the timer label. Turns red when time is below 5 seconds.
     * @param seconds remaining seconds
     */
    public void updateTimer(int seconds) {
        timerLabel.setText("Time: " + seconds);

        // Warning color when time is running out
        if (seconds <= 5) {
            timerLabel.setForeground(Color.RED);
        } else {
            timerLabel.setForeground(Color.BLACK);
        }
    }

    /**
     * Updates the score label.
     * @param score current score
     */
    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    /**
     * Highlights the correct answer in green.
     */
    public void showCorrectAnswer() {
        Question current = quizManager.getCurrentQuestion();

        if (current instanceof MultipleChoiceQuestion multipleChoice) {
            // Highlight correct button green
            answerButtons[multipleChoice.getCorrectIndex()].setBackground(Color.GREEN);

        } else if (current instanceof TrueFalseQuestion trueFalse) {
            // Highlight correct true/false button
            if ((boolean) trueFalse.getCorrectAnswer()) {
                trueButton.setBackground(Color.GREEN);
            } else {
                falseButton.setBackground(Color.GREEN);
            }
        }
    }

    /**
     * Disables all answer buttons after an answer is submitted.
     * After a short delay moves to the next question or shows results.
     */
    public void lockAnswers() {
        // Disable all buttons
        for (JButton btn : answerButtons) {
            btn.setEnabled(false);
        }
        trueButton.setEnabled(false);
        falseButton.setEnabled(false);
        skipButton.setEnabled(false);

        // Wait 1.5 seconds then move to next question
        Timer delay = new Timer(1500, e -> {
            skipButton.setEnabled(true);
            if (quizManager.isQuizFinished()) {
                showResults();
            } else {
                quizManager.nextQuestion();
                displayQuestion(quizManager.getCurrentQuestion());
                updateScore(quizManager.getCurrentScore());
            }
        });
        delay.setRepeats(false);
        delay.start();
    }

    /**
     * Switches the main panel to the result screen.
     */
    private void showResults() {
        MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(this);
        frame.switchPanel(new ResultPanel(quizManager.finishQuiz()));
    }
}