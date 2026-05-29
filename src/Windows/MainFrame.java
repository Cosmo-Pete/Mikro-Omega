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

    private void setupWindow() {
        setTitle("Quiz App");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1280, 720);
        setResizable(true);
        setLocationRelativeTo(null);

        // Save scoreboard on close
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                scoreBoard.save("src/resources/scoreboard.dat");
                System.exit(0);
            }
        });
    }

    /**
     * Initializes and displays the main menu panel.
     */
    private void setupGame() {
        scoreBoard = new ScoreBoard(10);
        scoreBoard.load("src/resources/scoreboard.dat");
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