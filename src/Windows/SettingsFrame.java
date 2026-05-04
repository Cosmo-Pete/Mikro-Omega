package Windows;

import javax.swing.*;
import java.awt.*;

public class SettingsFrame extends JFrame {

    // Reference to the main window
    private MainFrame mainFrame;

    private JCheckBox musicCheckBox;
    private JCheckBox soundCheckBox;
    private JComboBox<String> resolutionBox;
    private JButton saveButton;

    public SettingsFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setTitle("Settings");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(new JLabel("Game Settings"));

        musicCheckBox = new JCheckBox("Music");
        panel.add(musicCheckBox);

        soundCheckBox = new JCheckBox("Sounds");
        panel.add(soundCheckBox);

        panel.add(new JLabel("Resolution:"));

        String[] resolutions = {
                "1280x720",
                "1366x768",
                "1600x900",
                "1920x1080",
                "2560x1440",
                "3840x2160"
        };

        resolutionBox = new JComboBox<>(resolutions);
        panel.add(resolutionBox);

        saveButton = new JButton("Save");
        panel.add(saveButton);

        // Listener on save button
        saveButton.addActionListener(e -> applyResolution());

        add(panel);
    }

    /**
     * Applies the selected resolution to the main window.
     * Parses the resolution string and resizes the MainFrame accordingly.
     */
    private void applyResolution() {
        try {
            // Get selected resolution e.g. "1280x720"
            String selected = (String) resolutionBox.getSelectedItem();

            // Split the string into two numbers
            String[] parts = selected.split("x");
            int width = Integer.parseInt(parts[0]);
            int height = Integer.parseInt(parts[1]);

            // Apply to MainFrame
            mainFrame.setSize(width, height);
            mainFrame.setLocationRelativeTo(null);

            JOptionPane.showMessageDialog(this, "Resolution changed to " + selected);

        } catch (NumberFormatException e) {
            // If parsing fails
            JOptionPane.showMessageDialog(this, "Error changing resolution!",
                    "Error", JOptionPane.ERROR_MESSAGE);

            //Todo přidat kontrolu aby uživatel nemohl zvětšit okno na větší rozlišení než má obrazovku
        }
    }
}