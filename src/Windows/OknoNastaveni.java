package Windows;

import javax.swing.*;
import java.awt.*;

public class OknoNastaveni extends JFrame {

    public OknoNastaveni() {
        setTitle("Nastavení");
        setSize(400, 300);
        setLocationRelativeTo(null); // vycentruje okno
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(new JLabel("Nastavení hry"));

        JCheckBox hudba = new JCheckBox("Hudba");
        panel.add(hudba);

        JCheckBox zvuky = new JCheckBox("Zvuky");
        panel.add(zvuky);

        panel.add(new JLabel("Rozlišení:"));

        String[] rozliseni = {
                "1280x720",
                "1366x768",
                "1600x900",
                "1920x1080",
                "2560x1440",
                "3840x2160"
        };
        JComboBox<String> boxRozliseni = new JComboBox<>(rozliseni);
        panel.add(boxRozliseni);
        add(panel);
    }
}