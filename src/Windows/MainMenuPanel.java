package Windows;

import Logic.QuestionBank;
import Logic.QuizManager;
import Logic.ScoreBoard;
import javax.swing.*;
import java.awt.*;
import Model.Category;
import Model.Player;
import Model.Question;

import javax.swing.*;
import java.awt.*;
import java.util.List;      // ← musí být java.util.List ne java.awt.List

public class MainMenuPanel extends JPanel {

    private MainFrame mainFrame;
    private ScoreBoard scoreBoard;

    private JTextField playerNameField;
    private JComboBox<String> categoryBox;
    private JComboBox<String> difficultyBox;
    private JButton startButton;
    private JButton scoreBoardButton;
    private JButton settingsButton;
    private JLabel titleLabel;
    private JLabel errorLabel;          // shows error if name is empty
    private JButton exitButton;
    /**
     * Creates the main menu panel with navigation and game setup options.
     * @param mainFrame reference to the main window
     * @param scoreBoard reference to the scoreboard
     */
    public MainMenuPanel(MainFrame mainFrame, ScoreBoard scoreBoard) {
        this.mainFrame = mainFrame;
        this.scoreBoard = scoreBoard;
        initComponents();
        setupLayout();
        setupListeners();
    }

    /**
     * Initializes all UI components with default values.
     */
    private void initComponents() {
        titleLabel = new JLabel("Quiz App", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));

        playerNameField = new JTextField(20);
        playerNameField.setFont(new Font("Arial", Font.PLAIN, 16));

        // Category options
        String[] categories = {"IT", "Mathematics", "Geography"};
        categoryBox = new JComboBox<>(categories);
        categoryBox.setFont(new Font("Arial", Font.PLAIN, 16));

        // Difficulty options
        String[] difficulties = {"Easy", "Medium", "Hard"};
        difficultyBox = new JComboBox<>(difficulties);
        difficultyBox.setFont(new Font("Arial", Font.PLAIN, 16));

        startButton = new JButton("Start Quiz");
        startButton.setFont(new Font("Arial", Font.BOLD, 18));

        scoreBoardButton = new JButton("Scoreboard");
        scoreBoardButton.setFont(new Font("Arial", Font.PLAIN, 16));

        settingsButton = new JButton("Settings");
        settingsButton.setFont(new Font("Arial", Font.PLAIN, 16));

        // Error label – hidden by default
        errorLabel = new JLabel("Please enter your name!", SwingConstants.CENTER);
        errorLabel.setForeground(Color.RED);
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        errorLabel.setVisible(false);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 16));
    }

    /**
     * Sets up the layout of all components.
     * Title at top, form in center, buttons at bottom.
     */
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        // --- TOP: title ---
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        topPanel.add(titleLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        // --- CENTER: form ---
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Player name row
        gbc.gridx = 0; gbc.gridy = 0;
        centerPanel.add(new JLabel("Your name:"), gbc);
        gbc.gridx = 1;
        centerPanel.add(playerNameField, gbc);

        // Category row
        gbc.gridx = 0; gbc.gridy = 1;
        centerPanel.add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        centerPanel.add(categoryBox, gbc);

        // Difficulty row
        gbc.gridx = 0; gbc.gridy = 2;
        centerPanel.add(new JLabel("Difficulty:"), gbc);
        gbc.gridx = 1;
        centerPanel.add(difficultyBox, gbc);

        // Error label
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        centerPanel.add(errorLabel, gbc);

        add(centerPanel, BorderLayout.CENTER);

        // --- BOTTOM: buttons ---
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.add(startButton);
        bottomPanel.add(scoreBoardButton);
        bottomPanel.add(settingsButton);
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(exitButton);
    }

    /**
     * Sets up action listeners for all buttons.
     */
    private void setupListeners() {
        // Start quiz – validate name first
        startButton.addActionListener(e -> {
            if (getPlayerName().isEmpty()) {
                errorLabel.setVisible(true);
                return;
            }
            errorLabel.setVisible(false);

            // Create player object
            Player player = new Player(getPlayerName());

            // Get questions from QuestionBank
            QuestionBank questionBank = new QuestionBank();
            List<Question> questions = questionBank.getByCategoryAndDifficulty(
                    getSelectedCategory(),
                    getSelectedDifficulty()
            );

            // Create QuizManager and switch to GamePanel
            QuizManager quizManager = new QuizManager(player, questions);
            mainFrame.switchPanel(new GamePanel(quizManager));
        });

        // Open scoreboard – disable button while open
        scoreBoardButton.addActionListener(e -> {
            ScoreBoardWindow window = new ScoreBoardWindow(scoreBoard);
            window.setVisible(true);
            scoreBoardButton.setEnabled(false);
            window.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    scoreBoardButton.setEnabled(true);
                }
            });
        });

        // Open settings – disable button while open
        settingsButton.addActionListener(e -> {
            SettingsFrame settings = new SettingsFrame(mainFrame, this);
            settings.setVisible(true);
            settingsButton.setEnabled(false);
            settings.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    settingsButton.setEnabled(true);
                }
            });
        });

        // Exit application
        exitButton.addActionListener(e -> System.exit(0));
    }

    /**
     * Sets the player name in the text field.
     * @param name player name to set
     */
    public void setPlayerName(String name) {
        playerNameField.setText(name);
    }

    /**
     * Returns the player name entered in the text field.
     * @return player name or empty string
     */
    public String getPlayerName() {
        return playerNameField.getText().trim();
    }

    /**
     * Returns the selected category.
     * @return category name
     */
    public String getSelectedCategory() {
        return (String) categoryBox.getSelectedItem();
    }

    /**
     * Returns the selected difficulty.
     * @return difficulty name
     */
    public String getSelectedDifficulty() {
        return (String) difficultyBox.getSelectedItem();
    }
}