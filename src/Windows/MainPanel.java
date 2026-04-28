package Windows;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel() {
        setPreferredSize(new Dimension(1280, 720));
        setBackground(Color.WHITE);

        setLayout(new FlowLayout());

        JButton tlacitkoukonceni = new JButton("Ukončit");
        tlacitkoukonceni.addActionListener(e -> System.exit(0));
        add(tlacitkoukonceni);

        JButton tlacitkoHry = new JButton("Nová Hra");
        add(tlacitkoHry);

        JButton tlacitkoNastaveni = new JButton("Nastavení");
        tlacitkoNastaveni.addActionListener(e -> {
            new OknoNastaveni().setVisible(true);
        });
        add(tlacitkoNastaveni);
    }
}