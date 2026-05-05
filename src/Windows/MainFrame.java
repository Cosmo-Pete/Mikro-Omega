package Windows;

import javax.swing.*;

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
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setResizable(false);
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
}