package Windows;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    // Reference to the main window
    private MainFrame mainFrame;

    /**
     * Creates the main menu panel with buttons for navigation.
     * @param mainFrame reference to the main window
     */
    public MainPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setPreferredSize(new Dimension(1280, 720));
        setBackground(Color.WHITE);

        // Use SpringLayout for precise component positioning
        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        // Initialize buttons
        JButton exitButton = new JButton("Exit");
        JButton newGameButton = new JButton("New Game");
        JButton settingsButton = new JButton("Settings");

        add(exitButton);
        add(newGameButton);
        add(settingsButton);

        // Center all buttons horizontally and position them vertically
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, newGameButton,
                0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, newGameButton,
                250, SpringLayout.NORTH, this);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, settingsButton,
                0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, settingsButton,
                20, SpringLayout.SOUTH, newGameButton);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, exitButton,
                0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, exitButton,
                20, SpringLayout.SOUTH, settingsButton);

        // Button actions
        exitButton.addActionListener(e -> System.exit(0));

        settingsButton.addActionListener(e -> {
            new SettingsFrame(mainFrame).setVisible(true);
        });
    }
}