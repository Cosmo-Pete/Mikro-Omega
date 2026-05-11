package Windows;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    // Main panel of the application
    private MainPanel mainPanel;

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
     * Initializes and displays the main panel.
     */
    private void setupGame() {
        mainPanel = new MainPanel(this);
        add(mainPanel);
        pack();
        setVisible(true);
    }

    /**
     * Switches the content of the window to a new panel.
     * Removes the current panel and displays the new one.
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
    public MainPanel getMainPanel() {
        return mainPanel;
    }
}