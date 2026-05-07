package Windows;

import javax.swing.*;
import java.awt.*;

public class SettingsFrame extends JFrame {

    private MainFrame mainFrame;

    private JCheckBox musicCheckBox;
    private JCheckBox soundCheckBox;
    private JComboBox<Resolution> resolutionBox;
    private JButton saveButton;
    private JButton playerNameButton;

    private enum Resolution {
        HD(1280, 720, "HD"),
        HD_PLUS(1366, 768, "HD+"),
        FULL_HD(1920, 1080, "Full HD"),
        QHD(2560, 1440, "QHD"),
        UHD_4K(3840, 2160, "4K");

        final int width;
        final int height;
        final String label;

        Resolution(int width, int height, String label) {
            this.width = width;
            this.height = height;
            this.label = label;
        }

        @Override
        public String toString() {
            return label + " (" + width + "x" + height + ")";
        }
    }

    public SettingsFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setTitle("Settings");
        setSize(400, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title
        JLabel titleLabel = new JLabel("Game Settings");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(15));
        panel.add(titleLabel);

        // Music + Sound
        JPanel musicSoundPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        musicCheckBox = new JCheckBox("Music");
        soundCheckBox = new JCheckBox("Sounds");

        musicSoundPanel.add(musicCheckBox);
        musicSoundPanel.add(soundCheckBox);

        musicSoundPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(5));
        panel.add(musicSoundPanel);

        // Resolution
        JPanel resolutionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        resolutionPanel.add(new JLabel("Resolution:"));

        resolutionBox = new JComboBox<>(Resolution.values());
        resolutionPanel.add(resolutionBox);

        saveButton = new JButton("Save");
        resolutionPanel.add(saveButton);

        saveButton.addActionListener(e -> applyResolution());

        resolutionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(5));
        panel.add(resolutionPanel);

        // PlayerNameButton
        playerNameButton = new JButton("name set");
        playerNameButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(5));
        panel.add(playerNameButton);

        add(panel);
    }

    private void applyResolution() {
        Resolution res = (Resolution) resolutionBox.getSelectedItem();

        if (res == null) return;

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        if (res.width > screen.width || res.height > screen.height) {
            JOptionPane.showMessageDialog(
                    this,
                    "Rozlišení je větší než tvoje obrazovka!"
            );
            return;
        }

        mainFrame.setSize(res.width, res.height);
        mainFrame.setLocationRelativeTo(null);

        JOptionPane.showMessageDialog(
                this,
                "Resolution changed to "
                        + res.label
                        + " ("
                        + res.width
                        + "x"
                        + res.height
                        + ")"
        );
    }
}