package Windows;

import Logic.ScoreBoard;
import javax.swing.*;

public class MainFrame extends JFrame {

    private MainMenuPanel mainPanel;
    private ScoreBoard scoreBoard;

    public MainFrame() {
        setupWindow();
        setupGame();
    }

    /**
     * Configures the main window properties.
     */
    private void setupWindow() {
        setTitle("Quiz App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setResizable(true);
        setLocationRelativeTo(null);
    }

    /**
     * Initializes and displays the main menu panel.
     */
    private void setupGame() {
        scoreBoard = new ScoreBoard(10);
        mainPanel = new MainMenuPanel(this, scoreBoard);
        add(mainPanel);
        pack();
        setVisible(true);
    }

    /**
     * Switches the content of the window to a new panel.
     * @param panel the new panel to display
     */
    public void switchPanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }

    /**
     * Returns the main menu panel.
     * @return mainPanel
     */
    public MainMenuPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Returns the scoreboard.
     * @return scoreBoard
     */
    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }
}