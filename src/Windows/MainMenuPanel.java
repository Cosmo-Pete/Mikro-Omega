package Windows;

import javax.swing.*;

public class MainMenuPanel extends JPanel {

    private MainFrame mainFrame;

    private JTextField playerNameField;
    private JComboBox<String> categoryBox;
    private JComboBox<String> difficultyBox;
    private JButton startButton;
    private JButton scoreBoardButton;
    private JButton settingsButton;



    public MainMenuPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        setupLayout();
        setupListeners();
    }


    private void initComponents() {
    }

    private void setupLayout() {
        // TODO: Implementace
    }

    private void setupListeners() {
        // TODO: Implementace
    }

    // Gettery pro hodnoty
    public String getPlayerName() {
        return "";
    }

    public String getSelectedCategory() {
        return "";
    }

    public String getSelectedDifficulty() {
        return "";
    }
}