package Windows;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel() {
        setPreferredSize(new Dimension(1280, 720));
        setBackground(Color.WHITE);

        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        JButton tlacitkoukonceni = new JButton("Ukončit");
        JButton tlacitkoHry = new JButton("Nová Hra");
        JButton tlacitkoNastaveni = new JButton("Nastavení");

        add(tlacitkoukonceni);
        add(tlacitkoHry);
        add(tlacitkoNastaveni);

        // --- centrální zarovnání celé skupiny ---
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, tlacitkoHry,
                0, SpringLayout.HORIZONTAL_CENTER, this);

        layout.putConstraint(SpringLayout.NORTH, tlacitkoHry,
                250, SpringLayout.NORTH, this);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, tlacitkoNastaveni,
                0, SpringLayout.HORIZONTAL_CENTER, this);

        layout.putConstraint(SpringLayout.NORTH, tlacitkoNastaveni,
                20, SpringLayout.SOUTH, tlacitkoHry);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, tlacitkoukonceni,
                0, SpringLayout.HORIZONTAL_CENTER, this);

        layout.putConstraint(SpringLayout.NORTH, tlacitkoukonceni,
                20, SpringLayout.SOUTH, tlacitkoNastaveni);

        // akce
        tlacitkoukonceni.addActionListener(e -> System.exit(0));

        tlacitkoNastaveni.addActionListener(e -> {
            new SettingsFrame().setVisible(true);
        });
    }
}