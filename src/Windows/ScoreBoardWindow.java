package Windows;

import Logic.ScoreBoard;
import Model.QuizResult;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ScoreBoardWindow extends JFrame {

    private ScoreBoard scoreBoard;
    private JTable resultsTable;
    private JScrollPane scrollPane;
    private JButton closeButton;
    private JButton clearButton;
    private JComboBox<String> filterBox;    // filtr podle kategorie

    public ScoreBoardWindow(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        initComponents();
        setupLayout();
        setupListeners();
        loadResults();
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

    // Tabulka
    private void loadResults() {
        // TODO: Implementace
    }

    private void refreshTable(List<QuizResult> results) {
        // TODO: Implementace
    }

    public void applyFilter(String category) {
        // TODO: Implementace
    }
}