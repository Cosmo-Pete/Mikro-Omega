package Windows;

import Logic.ScoreBoard;
import Model.Category;
import Model.QuizResult;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ScoreBoardWindow extends JFrame {

    private ScoreBoard scoreBoard;
    private JTable resultsTable;
    private JScrollPane scrollPane;
    private JButton closeButton;
    private JButton clearButton;
    private JComboBox<String> filterBox;
    private int c = 5;

    /**
     * Creates the scoreboard window displaying all quiz results.
     * @param scoreBoard the scoreboard containing all results
     */
    public ScoreBoardWindow(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        initComponents();
        setupLayout();
        setupListeners();
        loadResults();
    }

    /**
     * Initializes all UI components including the results table.
     */
    private void initComponents() {
        setTitle("Scoreboard");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Table with columns
        String[] columns = {"Player", "Category", "Difficulty", "Score", "Accuracy", "Date"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // table is read-only
            }
        };
        resultsTable = new JTable(model);
        resultsTable.setFont(new Font("Arial", Font.PLAIN, 14));
        resultsTable.setRowHeight(25);
        resultsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        scrollPane = new JScrollPane(resultsTable);

        // Filter combobox – All + category names
        filterBox = new JComboBox<>();
        filterBox.addItem("All Categories");
        for (String cat : scoreBoard.getAvailableCategories()) {
            filterBox.addItem(cat);
        }

        closeButton = new JButton("Close");
        clearButton = new JButton("Clear All");
        clearButton.setForeground(Color.RED);
    }

    /**
     * Sets up the layout with filter on top, table in center, buttons at bottom.
     */
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));

        // --- TOP: filter ---
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        topPanel.add(new JLabel("Filter by category:"));
        topPanel.add(filterBox);
        add(topPanel, BorderLayout.NORTH);

        // --- CENTER: table ---
        add(scrollPane, BorderLayout.CENTER);

        // --- BOTTOM: buttons ---
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        bottomPanel.add(clearButton);
        bottomPanel.add(closeButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Sets up action listeners for buttons and filter.
     */
    private void setupListeners() {
        // Close window
        closeButton.addActionListener(e -> dispose());

        // Clear all results with confirmation
        clearButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to clear all results?",
                    "Clear Scoreboard",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                scoreBoard.clearAll();
                loadResults();
            }
        });

        // Filter by category
        filterBox.addActionListener(e -> {
            String selected = (String) filterBox.getSelectedItem();
            if (selected == null || selected.equals("All Categories")) {
                loadResults();
            } else {
                applyFilter(selected);
            }
        });
    }

    /**
     * Loads all results from the scoreboard and fills the table.
     */
    private void loadResults() {
        refreshTable(scoreBoard.getTopResults(c));
    }

    /**
     * Refreshes the table with the given list of results.
     * @param results list of quiz results to display
     */
    private void refreshTable(List<QuizResult> results) {
        DefaultTableModel model = (DefaultTableModel) resultsTable.getModel();
        model.setRowCount(0); // clear existing rows

        for (QuizResult r : results) {
            model.addRow(new Object[]{
                    r.getPlayer().getName(),
                    r.getCategory().getName(),
                    r.getDifficulty(),
                    r.getScore(),
                    String.format("%.1f%%", r.getAccuracyPercentage()),
                    r.getDate().toLocalDate().toString()
            });
        }
    }

    /**
     * Filters the table to show only results from the given category.
     * @param category category name to filter by
     */
    public void applyFilter(String category) {
        List<QuizResult> filtered = scoreBoard.getTopResults(c).stream()
                .filter(r -> r.getCategory().getName().equals(category))
                .toList();
        refreshTable(filtered);
    }
}